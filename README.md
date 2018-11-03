# My_BeanUtils
重复造轮子系列之BeanUtils的实现

最近一直在学习Java的一些基础知识，好多知识在大学里都被忽略掉了，在工作中才发现有很多要学习的，所以打算好好学习一下，在学到每个知识点的时候，
会重复造一些轮子吧，也就相当于对知识做一些总结和加深咯。

本期是第一个造轮子的项目，手写一个BeanUtils.copyProperties()函数。

在开发中，大家肯定都用到过Spring中的BeanUtils这个类，这个类可以把两个对象中同名同类型的public属性进行复制，本人在开发中经常用到，比如从数据库查出了
一条记录，封装到了一个Entity对象中，而在service中是不会用这个Entity对象进行传递的，必须要封装到一个XXXOutputData中，而在涉及到RPC远程调用和返回给
前端时，是必须使用XXXOutputDTO<XXXOutputData>的，这也是为了规范，所以涉及到大量的对象的复制。

我们都知道BeanUtils是利用反射来调用对象中的方法，进而实现对属性的设置。

其实Java中提供了一套用以描述Java Bean对象的属性和方法的“属性描述器”对象，名为PropertyDescriptor，它可以获取到Java Bean对象中的Getter和Setter方法，
进而可以利用反射机制去调用。

下面我们来看一下代码：


算了，大家自己看吧，注释也很详细，我就不讲了，具体的可以查查Java的内省机制

