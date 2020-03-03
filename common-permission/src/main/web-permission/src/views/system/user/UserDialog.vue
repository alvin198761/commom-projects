<template>
    <el-dialog :title="title" :visible.sync="show" :close-on-click-modal="false" :close-on-press-escape="false"
               width="50%">
        <el-form :model="form" ref="form" :rules="rules" label-width="100px">
            <el-row :gutter="10">
                <el-col :span="12">
                    <el-form-item label="姓名">
                        <el-input size="small" clearable placeholder="请输入姓名"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="电话">
                        <el-input size="small" clearable placeholder="请输入电话"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row :gutter="10">
                <el-col :span="12">
                    <el-form-item label="昵称">
                        <el-input size="small" clearable placeholder="请输入昵称"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="邮箱">
                        <el-input size="small" clearable placeholder="请输入邮箱"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row :gutter="10">
                <el-col :span="12">
                    <el-form-item label="部门">
                       <v-treeselect :multiple="true" :options="deptOptions"  placeholder="请选择部门" ></v-treeselect>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="岗位">
                        <el-select size="small" clearable style="width: 100%" placeholder="请选择岗位">
                        </el-select>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row :gutter="10">
                <el-col :span="12">
                    <el-form-item label="性别">
                        <el-radio-group>
                            <el-radio :label="1">男</el-radio>
                            <el-radio :label="0">女</el-radio>
                        </el-radio-group>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="状态">
                        <el-radio-group>
                            <el-radio :label="1">激活</el-radio>
                            <el-radio :label="0">禁用</el-radio>
                        </el-radio-group>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row :gutter="10">
                <el-col :span="24">
                    <el-form-item label="角色">
                        <el-select size="small" clearable style="width: 100%" placeholder="请选择角色">
                        </el-select>
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
        components: {},
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
                        children: [ {
                            id: 'aa',
                            label: 'aa',
                        }, {
                            id: 'ab',
                            label: 'ab',
                        } ],
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
                this.title = "添加用户";
                this.mode = 'save';
                this.form = this.initForm();
                this.initData();
                this.show = true;
            },
            showEditDialog(row) {
                this.title = "修改用户";
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