<template>
	<div class="main-containers">
		
		
		<div class="body-containers" :style='"horizontal" == "vertical" ? {"minHeight":"100vh","padding":"64px 0 0","margin":"0 0 0 210px","position":"relative","background":"rgba(64, 158, 255, .3)","display":"block"} : {"minHeight":"100vh","padding":"0","margin":"0","position":"relative","background":"#fff"}'>
			<div class="menu-preview" :style='{"borderColor":"#efefef","background":"url(http://codegen.caihongy.cn/20221116/57fabbaf9e604523bf7a69d456b428d1.jpg) fixed no-repeat center top","borderWidth":"0 0 0px 0","width":"100%","borderStyle":"solid","height":"auto"}'>
        <el-menu
            :default-active="activeIndex"
            class="el-menu-demo"
            mode="horizontal"
            @select="handleSelect"
            background-color="#545c64"
            text-color="#fff"
            :router="true"
            active-text-color="#ffd04b">
          <el-menu-item v-for="(menu, index) in menuList" :index="index + ''" :key="index" :route="menu.url">
            <i v-if="false" :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"14px","lineHeight":"40px","fontSize":"14px","height":"40px"}' :class="iconArr[index]"></i>
            <span :style='{"padding":"0 10px","lineHeight":"40px","fontSize":"14px","color":"inherit","height":"40px"}'>{{menu.name}}</span>
          </el-menu-item>
          <el-menu-item @click="goBackend">Backend management</el-menu-item>
          <el-menu-item v-if="counselor == 1" @click="goChat">Contact Consultant</el-menu-item>
          <el-menu-item index="8" @click="goMenu('/index/center')">Personal Center</el-menu-item>
          <el-menu-item v-if="Token" @click="logout" style="float:right; width: 130px; text-align: center;">quit</el-menu-item>
          <el-menu-item v-if="!Token" @click="toLogin()" style="float:right; width: 130px; text-align: center;">Login/register</el-menu-item>
        </el-menu>
			</div>
			
			<div class="banner-preview" :style='{"width":"100%","margin":"0","height":"auto"}'>
				<el-carousel :style='{"width":"100%","margin":"0 auto"}' trigger="click" indicator-position="inside" arrow="always" type="default" direction="horizontal" height="500px" :autoplay="true" :interval="3000" :loop="true">
					<el-carousel-item :style='{"borderRadius":"0","width":"100%","height":"100%"}' v-for="item in carouselList" :key="item.id">
						<el-image :style='{"objectFit":"cover","width":"100%","height":"100%"}' :src="baseUrl + item.value" fit="cover"></el-image>
					</el-carousel-item>
				</el-carousel>
			</div>
			
			<router-view></router-view>
			
			<div class="bottom-preview" :style='{"minHeight":"150px","padding":"20px 0","margin":"20px 0 0","alignItems":"center","color":"#fff","background":"#333","flexDirection":"column","display":"flex","width":"100%","justifyContent":"center"}'>
			    <img :style='{"width":"44px","objectFit":"cover","borderRadius":"100%","display":"none","height":"44px"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" >
			    <div :style='{"margin":"0","fontSize":"14px","lineHeight":"28px","color":"#fff"}'></div>
			    <div :style='{"margin":"10px 0 0","fontSize":"14px","lineHeight":"28px","color":"#fff"}'></div>
			    <div :style='{"margin":"10px 0 0","fontSize":"14px","lineHeight":"28px","color":"#fff"}'></div>
			</div>
		</div>
		
        <el-dialog title="Contact Consultant" :visible.sync="chatFormVisible" width="600px" :before-close="chatClose">
            <div class="chat-content"
                style="background: #f5f5f5;padding: 10px;box-sizing: border-box;overflow-y: scroll;max-height: 40vh;min-height: 40vh;">
                <div :class="{'right-content': item.reply == '' || item.reply == null, 'left-content': item.ask == '' || item.ask == null}"
                    v-for="item in chatList" :key="item.id">
                    <el-tag :type="(item.ask == '' || item.ask == null) ? 'warning' : 'success'" style="margin: 10px;">
                        {{(item.ask == '' || item.ask == null) ? item.reply : item.ask}}
                    </el-tag>
                </div>
            </div>
            <div slot="footer" class="dialog-footer">
                <el-input v-model="form.ask" placeholder="Please enter the content" style="width: calc(100% - 80px);float: left;">
                </el-input>
                <el-button type="primary" @click="addChat">send</el-button>
            </div>
        </el-dialog>
	</div>
</template>

<script>
import Vue from 'vue'
export default {
    data() {
		return {
            activeIndex: '0',
			roleMenus: [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-time","buttons":["new","check","modify","delete","Auditing","Gender ratio","Total number of homepage","Homepage statistics"],"menu":"user","menuJump":"list","tableName":"yonghu"}],"menu":"user management "},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["check","modify","delete","失物状态","状态比例","日失物量","View comments","Total number of homepage","Homepage statistics"],"menu":"失物招领","menuJump":"list","tableName":"shiwuzhaoling"}],"menu":"失物招领管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["check","modify","delete","日寻物量","View comments","Total number of homepage","Homepage statistics"],"menu":"寻物启事","menuJump":"list","tableName":"xunwuqishi"}],"menu":"寻物启事管理"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["check","delete"],"menu":"认领物品","menuJump":"list","tableName":"renlingwupin"}],"menu":"认领物品管理"},{"child":[{"appFrontIcon":"cuIcon-group","buttons":["check","modify","delete"],"menu":"Forum communication","tableName":"forum"}],"menu":"Forum communication"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["check","modify"],"menu":"关于我们","tableName":"aboutus"},{"appFrontIcon":"cuIcon-rank","buttons":["new","check","modify","delete"],"menu":"Carousel management","tableName":"config"},{"appFrontIcon":"cuIcon-wenzi","buttons":["check","modify"],"menu":"System Introduction","tableName":"systemintro"},{"appFrontIcon":"cuIcon-news","buttons":["new","check","modify","delete"],"menu":"Website Announcement","tableName":"news"},{"appFrontIcon":"cuIcon-service","buttons":["new","check","modify","delete"],"menu":"Contact Consultant","tableName":"chat"}],"menu":"system management"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["check","认领物品"],"menu":"失物招领列表","menuJump":"list","tableName":"shiwuzhaoling"}],"menu":"失物招领模块"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["check"],"menu":"寻物启事列表","menuJump":"list","tableName":"xunwuqishi"}],"menu":"寻物启事模块"}],"hasBackLogin":"yes","hasBackRegister":"no","hasFrontLogin":"no","hasFrontRegister":"no","roleName":"Administrator","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-list","buttons":["new","check","modify","delete","View comments"],"menu":"失物招领","menuJump":"list","tableName":"shiwuzhaoling"}],"menu":"失物招领管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["new","check","modify","delete","View comments"],"menu":"寻物启事","menuJump":"list","tableName":"xunwuqishi"}],"menu":"寻物启事管理"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["check","delete","Auditing"],"menu":"认领物品","menuJump":"list","tableName":"renlingwupin"}],"menu":"认领物品管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["check","认领物品"],"menu":"失物招领列表","menuJump":"list","tableName":"shiwuzhaoling"}],"menu":"失物招领模块"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["check"],"menu":"寻物启事列表","menuJump":"list","tableName":"xunwuqishi"}],"menu":"寻物启事模块"}],"hasBackLogin":"yes","hasBackRegister":"no","hasFrontLogin":"yes","hasFrontRegister":"yes","roleName":"user","tableName":"yonghu"}],
			baseUrl: '',
			carouselList: [],
			menuList: [],
			chatFormVisible: false,
			chatList: [],
			form: {
				ask: '',
				userid: localStorage.getItem('userid')
			},
			Token: localStorage.getItem('Token'),
      counselor: localStorage.getItem('counselor'),
			timer: '',
			iconArr: [
				'el-icon-star-off',
				'el-icon-goods',
				'el-icon-warning',
				'el-icon-question',
				'el-icon-info',
				'el-icon-help',
				'el-icon-picture-outline-round',
				'el-icon-camera-solid',
				'el-icon-video-camera-solid',
				'el-icon-video-camera',
				'el-icon-bell',
				'el-icon-s-cooperation',
				'el-icon-s-order',
				'el-icon-s-platform',
				'el-icon-s-operation',
				'el-icon-s-promotion',
				'el-icon-s-release',
				'el-icon-s-ticket',
				'el-icon-s-management',
				'el-icon-s-open',
				'el-icon-s-shop',
				'el-icon-s-marketing',
				'el-icon-s-flag',
				'el-icon-s-comment',
				'el-icon-s-finance',
				'el-icon-s-claim',
				'el-icon-s-opportunity',
				'el-icon-s-data',
				'el-icon-s-check'
			],
		}
    },
    created() {
		this.baseUrl = this.$config.baseUrl;
		this.menuList = this.$config.indexNav;
    this.menuList2 = [];

    for (let x in this.menuList) {
      if (this.counselor == 0) {
        if (this.menuList[x].name == 'Forum communication' || this.menuList[x].name == 'Website Announcement' || this.menuList[x].name == 'home page') {
          this.menuList2.push(this.menuList[x]);
        }
      } else {
        this.menuList2.push(this.menuList[x]);
      }
    }
    this.menuList = this.menuList2;

		this.getCarousel();
        if(localStorage.getItem('Token')) {
            this.saveChathelper('Master, I am your intelligent assistant Xiao Bo. May I help you！');
            this.getChatList();
        }
    },
    mounted() {
        this.activeIndex = localStorage.getItem('keyPath') || '0';
    },
    watch: {
        $route(newValue) {
            let that = this
            let url = window.location.href
            let arr = url.split('#')
            for (let x in this.menuList) {
                if (newValue.path == this.menuList[x].url) {
                    this.activeIndex = x
                }
            }
            this.Token = localStorage.getItem('Token')
        },
    },
    methods: {
        handleSelect(keyPath) {
            if (keyPath) {
                localStorage.setItem('keyPath', keyPath)
            }
        },
		toLogin() {
		  this.$router.push('/login');
		},
        logout() {
            localStorage.clear();
            Vue.http.headers.common['Token'] = "";
            this.$router.push('/index/home');
            this.activeIndex = '0'
            localStorage.setItem('keyPath', this.activeIndex)
            this.Token = ''
            this.$forceUpdate()
            this.$message({
                message: 'Login successful',
                type: 'success',
                duration: 1000,
            });
        },
		getCarousel() {
			this.$http.get('config/list', {params: { page: 1, limit: 3 }}).then(res => {
				if (res.data.code == 0) {
					this.carouselList = res.data.data.list;
				}
			});
		},
		goBackend() {
			window.open(`${this.$config.baseUrl}admin/dist/index.html`, "_blank");
		},
		getChatList() {
			this.$http.get('chat/list', {params: { userid: localStorage.getItem('userid'), sort: 'addtime', order: 'asc',limit: 1000 }}).then(res => {
				if (res.data.code == 0) {
					this.chatList = res.data.data.list;
                    let div = document.getElementsByClassName('chat-content')[0]
                    setTimeout(() => {
                        if (div)
                            div.scrollTop = div.scrollHeight
                    }, 0)
				}
			});
		},
		addChat() {
			this.$http.post('chat/add', this.form).then(res => {
				if (res.data.code == 0) {
					this.form.ask = '';
					this.getChatList();
				}
			});
		},
		chatClose() {
			clearInterval(this.timer);
			this.chatFormVisible = false;
		},
		goChat() {
            if(!localStorage.getItem('Token')) {
                this.toLogin();
                return;
            }
			this.chatFormVisible = true;
			this.timer = setInterval(this.getChatList, 2000);
		},
		goMenu(path) {
            if (!localStorage.getItem('Token')) {
                this.toLogin();
            } else {
                this.$router.push(path);
            }
		},
    }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.menu-preview {
	  .el-scrollbar {
	    height: 100%;
	
	    & /deep/ .scrollbar-wrapper {
	      overflow-x: hidden;
	    }
	  }
	}
	
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item {
		cursor: pointer;
		padding: 0;
		margin: 0 8px 0 0;
		color: #333;
		white-space: nowrap;
		display: flex;
		font-size: 14px;
		border-color: #F56C6C #F56C6C #F56C6C #F56C6C;
		line-height: 40px;
		//border-radius: 20%;
		background: linear-gradient(180deg, rgba(254,215,217,1) 0%, rgba(254,215,217,1) 51%, rgba(255,182,193,1) 51%, rgba(255,182,193,1) 100%);
		width: 120px;
		justify-content: center;
		border-width: 1px;
		position: relative;
		//border-style: solid;
		list-style: none;
		text-align: center;
		height: 40px;
	}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item:hover {
		cursor: pointer;
		padding: 0;
		margin: 0 8px 0 0;
		color: #333;
		white-space: nowrap;
		font-size: 14px;
    border-color: #F56C6C #F56C6C #F56C6C #F56C6C;
    line-height: 40px;
    //border-radius: 20%;
    background: radial-gradient(circle, rgba(245,108,108,1) 100%, rgba(245,108,108,1) 81%, rgba(245,108,108,1) 100%);
		width: 120px;
		border-width: 1px;
		position: relative;
		border-style: solid;
		list-style: none;
		height: 40px;
	}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.is-active {
		cursor: pointer;
		padding: 0;
		margin: 0 8px 0 0;
		color: #333;
		white-space: nowrap;
		font-size: 14px;
		border-color: #F56C6C #F56C6C #F56C6C #F56C6C;
		line-height: 40px;
		//border-radius: 20%;
		background: radial-gradient(circle, rgba(245,108,108,1) 100%, rgba(245,108,108,1) 81%, rgba(245,108,108,1) 100%);
		width: 120px;
		border-width: 1px;
		position: relative;
		border-style: solid;
		list-style: none;
		height: 40px;
	}
	
	.banner-preview {
	  .el-carousel /deep/ .el-carousel__indicator button {
	    width: 0;
	    height: 0;
	    display: none;
	  }
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left:hover {
		background: #2087c3;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right:hover {
		background: #2087c3;
	}

	.banner-preview .el-carousel /deep/ .el-carousel__indicators {
		padding: 0;
		margin: 0 0 12px 0;
		z-index: 2;
		position: absolute;
		list-style: none;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li {
		border-radius: 50%;
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 0.4;
		transition: 0.3s;
		height: 12px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li:hover {
		border-radius: 50%;
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 0.7;
		height: 12px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li.is-active {
		border-radius: 50%;
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 1;
		height: 12px;
	}

    .chat-content {
      .left-content {
          width: 100%;
          text-align: left;
      }
      .right-content {
          width: 100%;
          text-align: right;
      }
    }
</style>
