<template>
    <div id="app">
        <Layout></Layout>
    </div>
</template>

<script>
    import Layout from './views/layout/index.vue';

    export default {
        components: {Layout},
        data() {
            return {
                timer: null
            };
        },
        created() {

        },
        destroyed() {

        }
    }
</script>


<style lang="less">
    html, body, #app {
        width: 100%;
        height: 100%;
        margin: 0px;
    }

    .el-header, .el-footer, .el-header a, .el-footer a {
        background-color: #545c64;
        color: #fff;
        text-align: center;
        line-height: 60px;
        text-decoration: none;
    }

    .el-container:nth-child(5) .el-aside,
    .el-container:nth-child(6) .el-aside {
        line-height: 260px;
    }

    .el-container:nth-child(7) .el-aside {
        line-height: 320px;
    }

    .el-table td {
        padding: 2px 0 !important;
    }

    .vue-treeselect__control, .el-button-group, input, button, .el-range-editor.el-input__inner, .el-card, .el-message, .el-alert, textarea, .el-dialog, .el-select-dropdown, .el-tag, .el-radio-button:first-child .el-radio-button__inner, .el-radio-button:last-child .el-radio-button__inner, .el-popover, .el-message-box {
        border-radius: 0px !important;
    }

    .vue-treeselect__control {
        height: 30px !important;
        padding-left: 10px !important;
    }

    .el-form-item__content, .el-form-item__label {
        /*line-height: 30px;*/
    }

    .vue-treeselect__control, .el-button-group, .el-input__inner, .el-button, .el-cascader {
        /*height: 30px;*/
        line-height: 32px;
        font-size: 12px !important;

    }

    .el-button {
        padding: 0 20px;
    }

    .el-button--text {
        padding-right: 0px;
        padding-left: 0px;
    }

    .el-button--small, .el-button--small.is-round {
        padding: 7px 15px !important;
    }

    .el-tree-node__content {
        /*height: 32px;*/
    }

    /*下拉展示样式*/
    .el-table__expanded-cell .el-form {
        margin: 20px 0px 10px 58px;

    }

    /*    调整间距*/
    .el-form .el-row .el-col .el-form-item {
        margin-bottom: 15px;
    }

    /*调整验证距离*/
    .el-form-item__error {
        padding-top: 1px !important
    }

    .el-header {
        background-color: #B3C0D1;
        color: #333;
        line-height: 60px;
    }

    .el-aside {
        color: #333;
    }

    .form-table-expand {
        font-size: 0;
    }

    .form-table-expand label {
        width: 90px;
        color: #99a9bf;
    }

    .form-table-expand .el-form-item {
        margin-right: 0;
        margin-bottom: 0;
        width: 50%;
    }
</style>
