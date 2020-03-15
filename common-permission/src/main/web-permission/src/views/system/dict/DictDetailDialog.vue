<template>
    <el-dialog :title="title" :visible.sync="show" :close-on-click-modal="false" :close-on-press-escape="false"
               width="30%">
        <el-form :model="form" ref="form" :rules="rules" label-width="100px">
            <el-form-item label="字典标签">
                <el-input size="small" clearable placeholder="请输入字典标签" v-model="form.label"></el-input>
            </el-form-item>
            <el-form-item label="字典值">
                <el-input size="small" clearable placeholder="请输入字典值" v-model="form.value"></el-input>
            </el-form-item>
            <el-form-item label="排序">
                <el-input size="small" controlsPosition="right" :min="1" :max="100" clearable type="number"
                                 placeholder="请输入排序 1-100" v-model.number="form.sort"
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
                rules: {
                    label: [
                        {required: true, type: 'string', message: '请输入字典标签', trigger: 'blur'},
                    ],
                    value: [
                        {required: true, type: 'string', message: '请输入字典值', trigger: 'blur'},
                    ],
                    sort: [
                        {required: true, type: 'number', message: '请输入字典排序', trigger: 'blur'},
                    ]
                },
            }
        },
        computed: {},
        created: function () {

        },
        methods: {
            selectIcon(icon) {
                this.form = {...this.form, icon: icon};
            },
            initForm() {
                return {
                    id: null,//  id
                    label: null,//  字典标签
                    value: null,//  字典值
                    sort: null,//  排序
                    dictId: null,//  字典id
                    createTime: null,//  创建日期
                }
            },
            initData() {
                //需要加载数据的方法
            },
            showAddDialog(dictId) {
                this.title = "添加字典";
                this.mode = 'save';
                this.form = this.initForm();
                this.form = {...this.form, dictId: dictId}
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
                    that.$postBody("/api/detail/" + that.mode, that.form).then(res => {
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