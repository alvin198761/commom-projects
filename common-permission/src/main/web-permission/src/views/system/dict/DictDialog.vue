<template>
    <el-dialog :title="title" :visible.sync="show" :close-on-click-modal="false" :close-on-press-escape="false"
               width="30%">
        <el-form :model="form" ref="form" :rules="rules" label-width="100px">
            <el-form-item label="字典名称" prop="name">
                <el-input size="small" clearable v-model="form.name" placeholder="请输入字典名称"></el-input>
            </el-form-item>
            <el-form-item label="字典描述" prop="remark">
                <el-input size="small" clearable v-model="form.remark" placeholder="请输入字典描述"></el-input>
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
                rules: {
                    name: [
                        {required: true, type: 'string', message: '请输入字典名称', trigger: 'blur'},
                    ]
                },
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
                    id: null,//  id
                    name: null,//  字典名称
                    remark: null,//  描述
                    createTime: null//  创建日期
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
                this.form = {...row};
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
                    that.$postBody("/api/dict/" + that.mode, that.form).then(res => {
                        that.saveLoading = false;
                        if (res.code !== 0) {
                            that.$message.error(res.errorMsg);
                            return;
                        }
                        that.$message.success(that.title + "成功!");
                        that.show = false;
                        that.refresh();
                    })
                });
            }
        }
    }
</script>
<style></style>