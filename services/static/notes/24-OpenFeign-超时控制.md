## OpenFeign超时控制
设置超时时间，防止远程调用失败，导致服务雪崩。  
超时返回错误信息，或者兜底信息。

![](./images/cloud-24-01.png)


### 连接超时、读取超时
A B直接相互调用，有建立连接，请求读取数据的行为。
![](./images/cloud-24-02.png)