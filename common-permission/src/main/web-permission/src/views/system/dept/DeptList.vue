<template>
    <div>
        <el-form inline>
            <div v-if="showSearch">
                <el-form-item>
                    <el-input placeholder="模糊搜索" size="small" clearable></el-input>
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
                    <el-button type="success" size="small" icon="el-icon-search" :loading="loading" @click="globalRefresh">搜索</el-button>
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
                        <el-button size="small" icon="el-icon-refresh" title="刷新数据"
                                   @click="globalRefresh()"></el-button>
                        <el-button size="small" icon="el-icon-s-grid" title="显示数据列"
                                   :disabled="true"></el-button>
                    </el-button-group>
                </el-col>
            </el-row>
        </el-form>
        <div style="margin-top: 20px;">
            <el-table size="small" :tree-props="{children: 'children', hasChildren: 'hasChildren'}" :data="dataList" row-key="id">
                <el-table-column type="selection" width="55"></el-table-column>
                <el-table-column label="名称" width="500"></el-table-column>
                <el-table-column label="状态" width="200">
                    <template slot-scope="props">
                        <el-switch v-model="props.row.status"></el-switch>
                    </template>
                </el-table-column>
                <el-table-column label="创建日期" width="500">
                    <template slot-scope="scope">{{ scope.row.date | date_time_filter}}</template>
                </el-table-column>
                <el-table-column label="操作" width="120" fixed="right">
                    <template slot-scope="scope">
                        <el-button type="success" icon="el-icon-edit" title="修改本行数据"></el-button>
                        <el-button type="danger" icon="el-icon-delete" title="删除本行数据"></el-button>
                    </template>
                </el-table-column>
            </el-table>

        </div>
        <DeptDialog ref="dialog" :refresh="globalRefresh"></DeptDialog>
    </div>
</template>
<script>
    import DeptDialog from './DeptDialog.vue';

    export default {
        components: {DeptDialog},
        data: function () {
            return {
                deptLoading: false,
                loading: false,
                showSearch: true,
                searchForm: {
                    status: 0
                },
                dataList: [],
            }
        },
        computed: {},
        created: function () {
            this.initData();
        },
        methods: {
            initData() {
                this.globalRefresh();
            },
            globalRefresh() {
                this.refresh();
            },
            refresh() {
                const that = this;
                that.loading = true;
                that.$postBody("/api/dept/queryTreeList", {...that.searchForm}).then(res => {
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
           delDept(id){

           }
        }
    }
</script>
<style></style>