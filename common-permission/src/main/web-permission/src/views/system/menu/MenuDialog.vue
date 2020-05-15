<template>
    <el-dialog :title="title" :visible.sync="show" :close-on-click-modal="false" :close-on-press-escape="false"
               width="50%">
        <el-form :model="form" ref="form" :rules="rules" label-width="100px">
            <el-row :gutter="10">
                <el-col :span="12">
                    <el-form-item label="菜单类型">
                        <el-radio-group v-model="form.type" size="small">
                            <el-radio-button :label="1">目录</el-radio-button>
                            <el-radio-button :label="2">菜单</el-radio-button>
                            <el-radio-button :label="3">按钮</el-radio-button>
                        </el-radio-group>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="所属系统">
                        <el-select :value="form.app_code" size="small" clearable style="width: 100%">
                            <el-option :value="1">系统</el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-form-item label="菜单图标">
                  <icon-picker v-model="form.icon"></icon-picker>

            </el-form-item>
            <el-row :gutter="10">
                <el-col :span="8">
                    <el-form-item label="是否外链">
                        <el-radio-group v-model="form.type" size="small">
                            <el-radio-button :label="1">是</el-radio-button>
                            <el-radio-button :label="0">否</el-radio-button>
                        </el-radio-group>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item label="是否可见">
                        <el-radio-group v-model="form.type" size="small">
                            <el-radio-button :label="1">是</el-radio-button>
                            <el-radio-button :label="0">否</el-radio-button>
                        </el-radio-group>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item label="是否缓存">
                        <el-radio-group v-model="form.type" size="small">
                            <el-radio-button :label="1">是</el-radio-button>
                            <el-radio-button :label="0">否</el-radio-button>
                        </el-radio-group>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row :gutter="10">
                <el-col :span="12">
                    <el-form-item label="菜单标题">
                        <el-input size="small" clearable="" placeholder="请输入菜单标题"/>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="权限标识">
                        <el-input size="small" clearable="" placeholder="请输入权限标识"/>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row :gutter="10">
                <el-col :span="12">
                    <el-form-item label="路由地址">
                        <el-input size="small" clearable="" placeholder="请输入路由地址"/>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="菜单顺序">
                        <el-input-number size="small" controlsPosition="right" clearable placeholder="请输入菜单顺序"
                                         style="width: 100%"/>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row :gutter="10">
                <el-col :span="12">
                    <el-form-item label="组件名称">
                        <el-input size="small" clearable="" placeholder="请输入组件名称"/>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="组件路径">
                        <el-input size="small" clearable="" placeholder="请输入组件路径"/>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-form-item label="上级目录">
                <v-treeselect :options="menuOptions" placeholder="请选择上级目录"></v-treeselect>
            </el-form-item>

        </el-form>
        <span slot="footer" class="dialog-footer">
 <el-button @click="show = false">取消</el-button>
            <el-button type="primary" @click="save()" :loading="saveLoading">确定</el-button>
  </span>
    </el-dialog>
</template>
<script>
    import ElInput from "../../../../node_modules/element-ui/packages/input/src/input.vue";

    export default {
        components: {ElInput},
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
                menuOptions: [
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
                this.title = "添加菜单";
                this.mode = 'save';
                this.form = this.initForm();
                this.initData();
                this.show = true;
            },
            showEditDialog(row) {
                this.title = "修改菜单";
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