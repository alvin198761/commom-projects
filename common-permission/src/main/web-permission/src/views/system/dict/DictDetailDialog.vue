<template>
    <el-dialog :title="title" :visible.sync="show" :close-on-click-modal="false" :close-on-press-escape="false"
               width="30%">
        <el-form :model="form" ref="form" :rules="rules" label-width="100px">
            <el-form-item label="字典标签">
                <el-input size="small" clearable="" placeholder="请输入字典标签"></el-input>
            </el-form-item>
            <el-form-item label="字典值">
                <el-input size="small" clearable="" placeholder="请输入字典值"></el-input>
            </el-form-item>
            <el-form-item label="排序">
                <el-input-number size="small" controlsPosition="right" clearable placeholder="请输入排序"
                                 style="width: 100%"/>
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
                this.title = "添加字典";
                this.mode = 'save';
                this.form = this.initForm();
                this.initData();
                this.show = true;
            },
            showEditDialog(row) {
                this.title = "修改字典";
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