<template>
    <el-dialog :title="title" :visible.sync="show" :close-on-click-modal="false" :close-on-press-escape="false"
               width="50%">
        <el-form :model="form" ref="form" :rules="rules" label-width="100px">
            <el-row :gutter="10">
                <el-col :span="12">
                    <el-form-item label="角色名称">
                        <el-input size="small" clearable placeholder="请输入角色名称"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="角色权限">
                        <el-input size="small" clearable placeholder="请输入角色权限"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row :gutter="10">
                <el-col :span="12">
                    <el-form-item label="数据范围">
                        <el-select size="small" clearable style="width: 100%" placeholder="请选择数据范围">
                            <el-option :value="1">全部</el-option>
                            <el-option :value="2">本级</el-option>
                            <el-option :value="3">本人</el-option>
                            <el-option :value="4">自定义</el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="级别">
                        <el-input-number controls-position="right"  :min="1" :max="999" size="small" clearable placeholder="请输入级别 0-999" style="width: 100% ;text-align: left"></el-input-number>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row :gutter="10" >
                <el-col :span="24">
                    <el-form-item label="自定义">
                        <v-treeselect :multiple="true" :options="deptOptions" placeholder="请选择部门"></v-treeselect>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row :gutter="10">

                <el-col :span="24">
                    <el-form-item label="描述">
                        <el-input size="small" clearable placeholder="请输描述" type="textarea" :rows="4"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

        </el-form>
        <span slot="footer" class="dialog-footer">
 <el-button @click="show = false">取消</el-button>
            <el-button type="primary" @click="save()" :loading="saveLoading">确定</el-button>
  </span>
    </el-dialog>
</template>
<script>



    export default {
        components: { },
        props: ['refresh'],
        data: function () {
            return {
                title: '',
                show: false,
                saveLoading: false,
                form: this.initForm(),
                mode: null,
                rules: {},
                deptOptions: [
                    {
                        id: 'a',
                        label: 'a',
                        children: [{
                            id: 'aa',
                            label: 'aa',
                        }, {
                            id: 'ab',
                            label: 'ab',
                        }],
                    }, {
                        id: 'b',
                        label: 'b',
                    }, {
                        id: 'c',
                        label: 'c',
                    }
                ]
            }
        },
        computed: {},
        created: function () {

        },
        methods: {
            initForm() {
                return {}
            },
            initData() {
                //需要加载数据的方法
            },
            showAddDialog() {
                this.title = "添加角色";
                this.mode = 'save';
                this.form = this.initForm();
                this.initData();
                this.show = true;
            },
            showEditDialog(row) {
                this.title = "修改角色";
                this.mode = 'update';
                this.form = row;
                this.initData();
                this.show = true;
            },
            save() {
                const that = this;
                this.$refs['form'].validate((valid) => {
                    if (!valid) {
                        return;
                    }
                    that.saveLoading = true;
                    that.$postBody("/api/user/" + that.mode, that.form).then(res => {
                        that.show = false;
                        that.saveLoading = false;
                        if (res.code !== 0) {
                            that.$message.success(res.errorMsg);
                            return;
                        }
                        that.$message.success(that.title + "成功!");
                        that.refresh();
                    })
                });
            }

        }
    }
</script>
<style></style>