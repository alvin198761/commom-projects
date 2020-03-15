<template>
    <div>
        <el-row :gutter="20">
            <el-col :span="10">
                <el-card>
                    <div slot="header">
                        <span>字典列表</span>
                        <el-button type="primary" style="float: right; " icon="el-icon-plus" size="small"
                                   @click="addDialog">新增
                        </el-button>
                    </div>
                    <div>
                        <el-form inline>
                            <el-form-item>
                                <el-input placeholder="输入名称或描述搜索" size="small" v-model="searchForm.name"
                                          clearable></el-input>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="success" size="small" icon="el-icon-search" @click="globalRefresh">搜索
                                </el-button>
                                <!--<el-button type="warning" size="small" icon="el-icon-download">导出</el-button>-->
                            </el-form-item>
                        </el-form>
                        <div style="margin-top: 20px;">
                            <el-table size="small" row-key="id" :data="dataList" v-loading="loading"
                                      element-loading-text="拼命加载中" highlight-current-row
                                      element-loading-spinner="el-icon-loading" @row-click="dictRowClick">
                                <el-table-column label="名称" width="200" prop="name"></el-table-column>
                                <el-table-column label="描述" prop="remark"></el-table-column>
                                <el-table-column label="操作" width="140" fixed="right">
                                    <template slot-scope="props">
                                        <el-button type="success" icon="el-icon-edit" title="修改本行数据" size="mini"
                                                   @click="editDialog(props.row)"></el-button>
                                        <el-button type="danger" icon="el-icon-delete" title="删除本行数据" size="mini"
                                                   @click="deleteRow(props.row)"
                                                   :loading="deleteId == props.row.id"></el-button>
                                    </template>
                                </el-table-column>
                            </el-table>
                            <br/>
                            <div style="text-align: right" v-if="page.total > 0">
                                <el-pagination small layout="total,sizes,prev, pager, next" :current-page="page.page"
                                               :total="page.total"
                                               @current-change="(curr) => {this.page = {...this.page,page: curr} ; this.refresh();}"
                                               :page-sizes="[10, 15, 20, 30,50, 100]"
                                               @size-change="(s) => {this.page = {...this.page,size: s} ; this.refresh();}"
                                               :page-size="page.size"></el-pagination>
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
                                <el-input placeholder="输入字典标签搜索" size="small" clearable v-model="dictDetailSearchForm.label"></el-input>
                            </el-form-item>
                            <el-form-item>
                                <el-button type="success" size="small" icon="el-icon-search" @click="detailGlobalRefresh">搜索</el-button>
                            </el-form-item>
                        </el-form>
                        <div style="margin-top: 20px;">
                            <el-table size="small" row-key="id" :data="dictDetailDataList" v-loading="dictDetailLoading"
                                      element-loading-text="拼命加载中"
                                      element-loading-spinner="el-icon-loading">
                                <el-table-column label="所属字典" width="180" prop="dictName"></el-table-column>
                                <el-table-column label="字典标签" width="180" prop="label"></el-table-column>
                                <el-table-column label="字典值" width="200" prop="value"></el-table-column>
                                <el-table-column label="排序" width="80" prop="sort"></el-table-column>
                                <el-table-column label="操作" width="140" fixed="right">
                                    <template slot-scope="props">
                                        <el-button type="success" icon="el-icon-edit" title="修改本行数据" size="mini" @click="editDetailDialog(props.row)"></el-button>
                                        <el-button type="danger" icon="el-icon-delete" title="删除本行数据" size="mini" :loading="dictDetailDeleteId === props.row.id"></el-button>
                                    </template>
                                </el-table-column>
                            </el-table>
                            <br/>
                            <div style="text-align: right" v-if="dictDetailPage.total > 0">
                                <el-pagination small layout="total,sizes,prev, pager, next" :current-page="dictDetailPage.page"
                                               :total="dictDetailPage.total"
                                               @current-change="(curr) => {this.dictDetailPage = {...this.dictDetailPage,page: curr} ; this.detailRefresh();}"
                                               :page-sizes="[10, 15, 20, 30,50, 100]"
                                               @size-change="(s) => {this.dictDetailPage = {...this.dictDetailPage,size: s} ; this.detailRefresh();}"
                                               :page-size="dictDetailPage.size"></el-pagination>
                            </div>
                        </div>
                    </div>
                </el-card>
            </el-col>
        </el-row>
        <DictDialog ref="dialog" :refresh="globalRefresh"></DictDialog>
        <DictDetailDialog ref="detailDialog" :refresh="detailGlobalRefresh"></DictDetailDialog>
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
                deleteId: null,
                searchForm: {
                    name: null
                },
                page: {
                    page: 1,
                    size: 10,
                    total: 0
                },
                dataList: [],
                currentDict: null,
                //
                dictDetailLoading: false,
                dictDetailDeleteId: null,
                dictDetailSearchForm: {
                    label: null
                },
                dictDetailPage: {
                    page: 1,
                    size: 10,
                    total: 0
                },
                dictDetailDataList: [],
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
                this.page = {page: 1, size: 10, total: 0};
                this.refresh();
            },
            refresh() {
                const that = this;
                that.loading = true;
                const requestData = {...that.searchForm, ...that.page, page: that.page.page - 1};
                that.$postBody("/api/dict/queryPage", requestData).then(res => {
                    that.loading = false;
                    if (res.code !== 0) {
                        that.$message.error(res.errorMsg);
                        that.dataList = [];
                        that.page = {page: 1, size: that.page.size, total: 0};
                        return;
                    }
                    that.dataList = res.data.content;
                    that.page = {page: 0, size: res.data.size, total: res.data.totalElements};
                })
            },
            addDialog() {
                this.$refs["dialog"].showAddDialog();
            },
            editDialog(row) {
                this.$refs["dialog"].showEditDialog(row);
            },
            deleteRow(row) {
                const that = this;
                this.$confirm('此操作将永久删除所选项, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    that.deleteId = row.id;
                    that.$post("/api/dict/delete", {id: row.id}).then(res => {
                        that.deleteId = null;
                        if (res.code !== 0) {
                            that.$message.error(res.errorMsg);
                            return;
                        }
                        that.globalRefresh();
                    })
                }).catch(() => {
                    console.log("选择了取消")
                });
            },
            dictRowClick(row, column, event) {
                this.currentDict = {...row};
                this.detailGlobalRefresh();
            },
            detailGlobalRefresh() {
                this.dictDetailPage = {page: 1, size: 10, total: 0};
                this.detailRefresh();
            },
            detailRefresh() {
                const that = this;
                that.dictDetailLoading = true;
                const requestData = {
                    ...that.dictDetailSearchForm,
                    dictId: that.currentDict.id, ...that.dictDetailPage,
                    page: that.dictDetailPage.page - 1
                };
                that.$postBody("/api/detail/queryPage", requestData).then(res => {
                    that.dictDetailLoading = false;
                    if (res.code !== 0) {
                        that.$message.error(res.errorMsg);
                        that.dictDetailDataList = [];
                        that.dictDetailPage = {page: 1, size: that.dictDetailPage.size, total: 0};
                        return;
                    }
                    that.dictDetailDataList = res.data.content;
                    that.dictDetailPage = {page: 0, size: res.data.size, total: res.data.totalElements};
                })
            },
            addDetailDialog() {
                this.$refs["detailDialog"].showAddDialog(this.currentDict.id);
            },
            editDetailDialog(row) {
                this.$refs["detailDialog"].showEditDialog(row);
            },
        }
    }
</script>
<style></style>