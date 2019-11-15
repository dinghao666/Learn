## BootStrap模态框的使用

### 1.创建模态框

```html
<h2>创建模态框（Modal）</h2>
<!-- 按钮触发模态框 -->
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">开始演示模态框</button>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">模态框（Modal）标题</h4>
            </div>
            <div class="modal-body">在这里添加一些文本</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">提交更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
```



### 2.模态框的打开

- 静态打开：通过data属性打开模态框

在控制器元素（比如按钮或者链接）上设置属性 **data-toggle="modal"**，同时设置 **data-target="#identifier"** 或 **href="#identifier"** 来指定要切换的特定的模态框（带有 id="identifier"）。

- 动态打开：通过js代码

使用这种技术，您可以通过简单的一行 JavaScript 来调用带有 id="myModal" 的模态框：

```javascript
$("#myModal").modal({

remote:"test/test.jsp";//可以填写一个url，会调用jquery load方法加载数据

backdrop:"static";//指定一个静态背景，当用户点击背景处，modal界面不会消失

keyboard:true;//当按下esc键时，modal框消失

})

remote处可以填写jsp路径或者html路径，用来给modal框注入内容

```

- 动态打开事件

**在modal框加载同时，提供几个方法用来控制modal框**

```javascript
$("#myModal").on("loaded.bs.modal",function{

//在模态框加载的同时做一些动作

});
```

```javascript
$("#myModal").on("show.bs.modal",function{

//在show方法后调用

});
```

```javascript
$("#myModal").on("shown.bs.modal",function{

//在模态框完全展示出来做一些动作

});
```

```javascript
$("#myModal").on("hide.bs.modal",function{

//hide方法后调用

});
```

```javascript
$("#myModal").on("hiden.bs.modal",function{

//监听模态框隐藏事件做一些动作

});
```

