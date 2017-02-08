# DesignLibSample

[![fishySample](https://img.shields.io/badge/fishy-sample-ff69b4.svg)]()
## 说明
总结design库，v4支持库，v7支持库中的从5.0之后MD设计风格开始的控件，布局的使用Sample。

</br>

## 时间线
### 2017-02-08
* 完成toolbar的Sample，Sample1给出将toolbar作为Actionbar的使用，Sample2给出toolbar作为自定义顶部栏的使用

</br>

## 小记
### **关于Toolbar**
#
> 将toolbar作为Actionbar使用的时候，需设置
```
setSupportActionBar(toolbar);
```
设置主标题需在此之前调用
```
toolbar.setTitle("主标题");
```
而设置导航icon需在此之后调用
```
toolbar.setNavigationIcon(R.mipmap.icon_navi);
```
> toolbar作为layout容器使用
需在xml布局中改变toolbar属性
```
app:contentInsetStart="0dp"
```
否则子布局无法完全填充满toolbar，左边会有间隙


</br>

