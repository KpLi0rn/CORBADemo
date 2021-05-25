# CORBADemo
## CORBA DEMO 来源：https://www.secpulse.com/archives/139999.html

CORBA 的 一个小 demo

文章：（还在写ing

`orbd -ORBInitialPort 1050 -ORBInitialHost 127.0.0.1`

![01](./images/01.png)

![02](./images/02.png)

![03](./images/03.png)

## RMI-IIOP DEMO 来源：https://xz.aliyun.com/t/7422#toc-6
执行
`orbd -ORBInitialPort 1050 -ORBInitialHost 127.0.0.1`

![04](./images/04.png)

进入到 RMIIIOP 目录下执行 

`java -classpath .  RMIIIOP.HelloServer`

![05](./images/05.png)

在当前目录下执行 

`java -classpath .  RMIIIOP.HelloClient`

![06](./images/06.png)

![07](./images/07.png)