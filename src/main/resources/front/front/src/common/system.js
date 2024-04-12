export function isAuth(tableName, key) {
  let role = localStorage.getItem("UserTableName");
  let menus = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-time","buttons":["new","check","modify","delete","Auditing","Gender ratio","Total number of homepage","Homepage statistics"],"menu":"user","menuJump":"list","tableName":"yonghu"}],"menu":"user management "},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["check","modify","delete","失物状态","状态比例","日失物量","View comments","Total number of homepage","Homepage statistics"],"menu":"失物招领","menuJump":"list","tableName":"shiwuzhaoling"}],"menu":"失物招领管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["check","modify","delete","日寻物量","View comments","Total number of homepage","Homepage statistics"],"menu":"寻物启事","menuJump":"list","tableName":"xunwuqishi"}],"menu":"寻物启事管理"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["check","delete"],"menu":"认领物品","menuJump":"list","tableName":"renlingwupin"}],"menu":"认领物品管理"},{"child":[{"appFrontIcon":"cuIcon-group","buttons":["check","modify","delete"],"menu":"Forum communication","tableName":"forum"}],"menu":"Forum communication"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["check","modify"],"menu":"关于我们","tableName":"aboutus"},{"appFrontIcon":"cuIcon-rank","buttons":["new","check","modify","delete"],"menu":"Carousel management","tableName":"config"},{"appFrontIcon":"cuIcon-wenzi","buttons":["check","modify"],"menu":"System Introduction","tableName":"systemintro"},{"appFrontIcon":"cuIcon-news","buttons":["new","check","modify","delete"],"menu":"Website Announcement","tableName":"news"},{"appFrontIcon":"cuIcon-service","buttons":["new","check","modify","delete"],"menu":"Contact Consultant","tableName":"chat"}],"menu":"system management"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["check","认领物品"],"menu":"失物招领列表","menuJump":"list","tableName":"shiwuzhaoling"}],"menu":"失物招领模块"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["check"],"menu":"寻物启事列表","menuJump":"list","tableName":"xunwuqishi"}],"menu":"寻物启事模块"}],"hasBackLogin":"yes","hasBackRegister":"no","hasFrontLogin":"no","hasFrontRegister":"no","roleName":"Administrator","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-list","buttons":["new","check","modify","delete","View comments"],"menu":"失物招领","menuJump":"list","tableName":"shiwuzhaoling"}],"menu":"失物招领管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["new","check","modify","delete","View comments"],"menu":"寻物启事","menuJump":"list","tableName":"xunwuqishi"}],"menu":"寻物启事管理"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["check","delete","Auditing"],"menu":"认领物品","menuJump":"list","tableName":"renlingwupin"}],"menu":"认领物品管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["check","认领物品"],"menu":"失物招领列表","menuJump":"list","tableName":"shiwuzhaoling"}],"menu":"失物招领模块"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["check"],"menu":"寻物启事列表","menuJump":"list","tableName":"xunwuqishi"}],"menu":"寻物启事模块"}],"hasBackLogin":"yes","hasBackRegister":"no","hasFrontLogin":"yes","hasFrontRegister":"yes","roleName":"user","tableName":"yonghu"}];
  for(let i=0;i<menus.length;i++){
    if(menus[i].tableName==role){
      for(let j=0;j<menus[i].frontMenu.length;j++){
          for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
            if(tableName==menus[i].frontMenu[j].child[k].tableName){
              let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
              return buttons.indexOf(key) !== -1 || false
            }
          }
      }
    }
  }
  return false;
}

/**
 *  * 获取当前时间（yyyy-MM-dd hh:mm:ss）
 *   */
export function getCurDateTime() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate(),
    hour = currentTime.getHours(),
    minute = currentTime.getMinutes(),
    second = currentTime.getSeconds();
    return year + "-" + month + "-" + day + " " +hour +":" +minute+":"+second;
}

/**
 *  * 获取当前日期（yyyy-MM-dd）
 *   */
export function getCurDate() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate();
    return year + "-" + month + "-" + day;
}
