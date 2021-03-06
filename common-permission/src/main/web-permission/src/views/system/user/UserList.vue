<template>
    <div>
        <el-row :gutter="20" style="margin-left: 10px; margin-right: 10px;">
            <el-col :span="4">
                <el-form :model="deptForm">
                    <el-form-item>
                        <el-input placeholder="根据部门名称搜索" v-model="deptForm.name" size="small" clearable
                                  @input="filterDeptChange">
                            <i slot="prefix" class="el-input__icon el-icon-search"></i>
                        </el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-tree ref="deptTree" empty-text="没有数据" :expand-on-click-node="false"
                                 default-expand-all :data="deptTreeDataList" :props="defaultProps"
                                 @node-click="deptTreeNodeClick" :filter-node-method="doDeptTreeFilter">
                        </el-tree>
                    </el-form-item>
                </el-form>
            </el-col>
            <el-col :span="20">
                <el-form inline>
                    <div v-if="showSearch">
                        <el-form-item>
                            <el-input placeholder="输入名称或邮箱搜索" size="small" clearable></el-input>
                        </el-form-item>
                        <el-form-item>
                            <el-date-picker
                                    type="daterange"
                                    range-separator="至"
                                    start-placeholder="开始日期"
                                    end-placeholder="结束日期"
                                    size="small" clearable
                            >
                            </el-date-picker>
                        </el-form-item>
                        <el-form-item>
                            <el-select v-model="searchForm.status" placeholder="状态" size="small" clearable>
                                <el-option label="激活" :value="1"></el-option>
                                <el-option label="禁用" :value="0"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="success" size="small" icon="el-icon-search">搜索</el-button>
                            <el-button type="warning" size="small" icon="el-icon-refresh-left">重置</el-button>
                        </el-form-item>
                    </div>
                    <el-row>
                        <el-col :span="12">
                            <el-button type="primary" size="small" icon="el-icon-plus" @click="addDialog()">新增
                            </el-button>
                            <el-button type="success" size="small" icon="el-icon-edit" @click="editDialog()">修改
                            </el-button>
                            <el-button type="danger" size="small" icon="el-icon-delete">删除</el-button>
                            <el-button type="warning" size="small" icon="el-icon-download">导出</el-button>
                        </el-col>
                        <el-col :span="12" style="text-align: right">
                            <el-button-group size="small">
                                <el-button size="small" icon="el-icon-search" title="显示搜索栏"
                                           :type="showSearch?'primary':''"
                                           @click="showSearch = !showSearch"></el-button>
                                <el-button size="small" icon="el-icon-refresh" title="刷新数据" @click="globalRefresh()"></el-button>
                                <el-button size="small" icon="el-icon-s-grid" title="显示数据列"
                                           :disabled="true"></el-button>
                            </el-button-group>
                        </el-col>
                    </el-row>
                </el-form>
                <div style="margin-top: 20px;">
                    <el-table size="small">
                        <el-table-column type="selection" width="55"></el-table-column>
                        <el-table-column label="用户名" width="120"></el-table-column>
                        <el-table-column label="昵称" width="120"></el-table-column>
                        <el-table-column label="性别" width="80"></el-table-column>
                        <el-table-column label="电话" width="120"></el-table-column>
                        <el-table-column label="邮箱" width="200"></el-table-column>
                        <el-table-column label="部门/岗位" width="200"></el-table-column>
                        <el-table-column label="状态" width="80"></el-table-column>
                        <el-table-column label="创建日期" width="120">
                            <template slot-scope="scope">{{ scope.row.date | date_time_filter}}</template>
                        </el-table-column>
                        <el-table-column label="操作" width="120" fixed="right">
                            <template slot-scope="scope">
                                <el-button type="success" icon="el-icon-edit" title="修改本行数据"></el-button>
                                <el-button type="danger" icon="el-icon-delete" title="删除本行数据"></el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                    <br/>
                    <div style="text-align: right" v-if="page.total > 0">
                        <el-pagination small layout="total,sizes,prev, pager, next" :current-page="page"
                                       :total="page.total"
                                       @current-change="(curr) => {this.page = {...this.page,page: curr} ; this.refresh();}"
                                       :page-sizes="[10, 15, 20, 30,50, 100]"
                                       @size-change="(s) => {this.page = {...this.page,size: curr} ; this.refresh();}"
                                       :page-size="size"></el-pagination>
                    </div>
                </div>
            </el-col>
        </el-row>
        <UserDialog ref="dialog" :refresh="globalRefresh"></UserDialog>
    </div>
</template>
<script>

    import UserDialog from './UserDialog.vue';

    export default {
        components: {UserDialog},
        data: function () {
            return {
                deptForm: {
                    name: null
                },
                deptTreeDataList: [
                    {
                        label: '一级 1',
                        children: [{
                            label: '二级 1-1',
                            children: [{
                                label: '三级 1-1-1'
                            }]
                        }]
                    }, {
                        label: '一级 2',
                        children: [{
                            label: '二级 2-1',
                            children: [{
                                label: '三级 2-1-1'
                            }]
                        }, {
                            label: '二级 2-2',
                            children: [{
                                label: '三级 2-2-1'
                            }]
                        }]
                    }, {
                        label: '一级 3',
                        children: [{
                            label: '二级 3-1',
                            children: [{
                                label: '三级 3-1-1'
                            }]
                        }, {
                            label: '二级 3-2',
                            children: [{
                                label: '三级 3-2-1'
                            }]
                        }]
                    }
                ],
                deptLoading: false,
                loading: false,
                showSearch: true,
                searchForm: {
                    status: 0
                },
                page: {
                    page: 1,
                    size: 10,
                    total: 0
                },
                dataList: [],
                defaultProps: {
                    children: 'children',
                    label: 'label'
                }

            }
        },
        computed: {},
        created: function () {
            this.initData();
        },
        methods: {
            initData() {
//                this.loadDeptTreeDataList();
//                this.refresh();
            },
            globalRefresh(){
                this.page = {page: 0 ,size: 10,total: 0};
                this.refresh();
            },
            loadDeptTreeDataList() {
                const that = this;
                that.deptLoading = true;
                that.$postBody("/api/dept/queryTreeDataList", that.deptForm).then(res => {
                    that.deptLoading = false;
                    if (res.code !== 0) {
                        that.$message.error(res.errorMsg);
                        return;
                    }
                    that.deptTreeDataList = res.data;
                });
            },
            refresh() {
                const that = this;
                that.loading = true;
                const requestData = {...that.searchForm, ...that.page};
                that.$postBody("/api/dept/queryPage", {...that.searchForm, ...that.page}).then(res => {
                    that.loading = false;
                    if (res.code !== 0) {
                        that.$message.error(res.errorMsg);
                        return;
                    }
                    that.dataList = res.data;
                })
            },
            addDialog() {
                this.$refs["dialog"].showAddDialog();
            },
            editDialog(row) {
                this.$refs["dialog"].showEditDialog(row);
            },
            deptTreeNodeClick(data) {
                console.log(data);
            },
            filterDeptChange() {
                this.$refs["deptTree"].filter(this.deptForm.name);
            },
            doDeptTreeFilter(value, data, node) {
                if (!value || value.length === 0) return true;
                return data.label.indexOf(value) !== -1;
            }
        }
    }
</script>
<style></style>