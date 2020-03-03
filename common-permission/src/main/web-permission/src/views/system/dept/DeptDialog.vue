<template>
    <el-dialog :title="title" :visible.sync="show" :close-on-click-modal="false" :close-on-press-escape="false"
               width="30%">
        <el-form :model="form" ref="form" :rules="rules" label-width="100px">
            <el-form-item label="部门名称">
               <el-input size="small" clearable="" placeholder="请输入部门名称"></el-input>
            </el-form-item>
            <el-form-item label="状态">
                <el-radio-group v-model="form.status" size="small">
                    <el-radio :label="1">启用</el-radio>
                    <el-radio  :label="0">禁用</el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item label="上级目录">
                <v-treeselect :options="deptOptions" placeholder="请选择上级目录"></v-treeselect>
            </el-form-item>

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
                showIconChooser: false,
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
            selectIcon(icon) {
                this.showIconChooser = false;
                this.form = {...this.form, icon: icon};
            },
            initForm() {
                return {
                    type: 1,
                    icon: null,
                }
            },
            initData() {
                //需要加载数据的方法
            },
            showAddDialog() {
                this.title = "添加部门";
                this.mode = 'save';
                this.form = this.initForm();
                this.initData();
                this.show = true;
            },
            showEditDialog(row) {
                this.title = "修改部门";
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