function delFruit(fid){
    if (confirm('是否删除？')){
        window.location.href='del.do?fid='+fid;
    }
}
function page(pageNo){
    window.location.href="index?pageNo="+pageNo;
}