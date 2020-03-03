import Vue from "vue";
import Router from "vue-router";
import RouterViewPage from "./views/RouterViewPage.vue";

import UserList from './views/system/user/UserList.vue';
import RoleList from './views/system/role/RoleList.vue';
import MenuList from './views/system/menu/MenuList.vue';
import DeptList from './views/system/dept/DeptList.vue';
import JobList from  './views/system/job/JobList.vue';
import DictList from  './views/system/dict/DictList.vue';

Vue.use(Router)
export const constantRoutes = [
    {
        path: '/',
        component: RouterViewPage,
        name: '首页',
        redirect: '/user',
        children: [
            {
                path: 'user',
                component: UserList,
                name: 'User',
                meta: {
                    title: '用户管理',
                    icon: 'el-icon-user'
                }
            }, {
                path: 'role',
                component: RoleList,
                name: 'Role',
                meta: {
                    title: '角色管理',
                    icon: 'el-icon-video-camera-solid'
                }
            }, {
                path: 'menu',
                component: MenuList,
                name: 'Menu',
                meta: {
                    title: '菜单管理',
                    icon: 'el-icon-menu'
                }
            }, {
                path: 'dept',
                component: DeptList,
                name: 'Dept',
                meta: {
                    title: '部门管理',
                    icon: 'el-icon-cherry'
                }
            }, {
                path: 'job',
                component: JobList,
                name: 'Job',
                meta: {
                    title: '岗位管理',
                    icon: 'el-icon-s-check'
                }
            }, {
                path: 'dict',
                component: DictList,
                name: 'Dict',
                meta: {
                    title: '字典管理',
                    icon: 'el-icon-s-check'
                }
            }
        ]
    }
]

export const asyncRoutes = [
    {path: '*', redirect: '/404', hidden: true}
]

const createRouter = () => new Router({
    scrollBehavior: () => ({y: 0}),
    routes: constantRoutes
})
const router = createRouter();
export default router;
