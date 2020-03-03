<template>
    <div>
        <el-row :gutter="20">
            <el-col :span="10">
                <el-card>
                    <div slot="header">
                        <span>字典列表</span>
                        <el-button type="primary" style="float: right; " icon="el-icon-plus" size="small" @click="addDialog">新增</el-button>
                    </div>
                    <div>
                        <el-form inline>
                            <el-form-item>
                                <el-input placeholder="输入名称或描述搜索" size="small" clearable></el-input>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="success" size="small" icon="el-icon-search">搜索</el-button>
                                <el-button type="warning" size="small" icon="el-icon-download">导出</el-button>
                            </el-form-item>
                        </el-form>
                        <div style="margin-top: 20px;">
                            <el-table size="small" :tree-props="{children: 'children', hasChildren: 'hasChildren'}"
                                      row-key="id">
                                <el-table-column label="名称" width="200"></el-table-column>
                                <el-table-column label="描述" width="200"></el-table-column>
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
                    </div>
                </el-card>
            </el-col>
            <el-col :span="14">
                <el-card>
                    <div slot="header">
                        <span>字典详情</span>
                        <el-button type="primary" style="float: right; " icon="el-icon-plus" size="small"
                                   v-if="currentDict !== null" @click="addDetailDialog">新增
                        </el-button>
                    </div>
                    <div v-if="currentDict === null" style="  position: relative;
    padding: 15px;
    line-height: 20px;
    border-left: 5px solid #ddd;
    color: #333;
    font-family: Courier New,serif;
    font-size: 12px;">点击字典查看详情
                    </div>
                    <div v-else>
                        <el-form inline>
                            <el-form-item>
                                <el-input placeholder="输入字典标签搜索" size="small" clearable></el-input>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="success" size="small" icon="el-icon-search">搜索</el-button>
                            </el-form-item>
                        </el-form>
                        <div style="margin-top: 20px;">
                            <el-table size="small" :tree-props="{children: 'children', hasChildren: 'hasChildren'}"
                                      row-key="id">
                                <el-table-column label="所属字典" width="200"></el-table-column>
                                <el-table-column label="字典标签" width="200"></el-table-column>
                                <el-table-column label="字典值" width="200"></el-table-column>
                                <el-table-column label="排序" width="80"></el-table-column>
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
                    </div>
                </el-card>
            </el-col>
        </el-row>
        <DictDialog ref="dialog" :refresh="globalRefresh"></DictDialog>
        <DictDetailDialog ref="detailDialog" :refresh="globalRefresh"></DictDetailDialog>
    </div>
</template>
<script>
    import DictDialog from './DictDialog.vue';
    import DictDetailDialog from './DictDetailDialog.vue';

    export default {
        components: {DictDialog, DictDetailDialog},
        data: function () {
            return {
                loading: false,
                searchForm: {
                    status: 0
                },
                page: {
                    page: 1,
                    size: 10,
                    total: 0
                },
                dataList: [],
                currentDict: {}
            }
        },
        computed: {},
        created: function () {
            this.initData();
        },
        methods: {
            initData() {
            },
            globalRefresh() {
                this.page = {page: 0, size: 10, total: 0};
                this.refresh();
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
            addDetailDialog() {
                this.$refs["detailDialog"].showAddDialog();
            },
            editDetailDialog(row) {
                this.$refs["detailDialog"].showEditDialog(row);
            },
            deptTreeNodeClick(data) {
                console.log(data)
            }
        }
    }
</script>
<style></style>