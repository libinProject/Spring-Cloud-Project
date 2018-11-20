### 基于Spring Cloud 项目搭建

> 说明：spring cloud项目搭建，持续更新

#### 修改记录

#####  1. spring cloud oauth2.0集成

+ JWT的方式 （JSON WEB TOKENS）

  >1. 生成 keystore.jks (放在认证服务器)
  >
  >   ```
  >   keytool -genkeypair -alias testkey -validity 3650 -keyalg RSA -dname "CN=jwt,OU=jtw,O=jtw,L=zurich,S=zurich,C=CH" -keypass passkey -keystore keystore.jks -storepass passkey
  >   ```
  >
  >2. Jwt 解密公钥 (放在资源服务器)  public.cert
  >
  >   ```
  >   keytool -list -rfc --keystore keystore.jks | openssl x509 -inform pem -pubkey
  >   ```
  >
  >3. 认证服务 （auth-jwt-center）
  >
  >   token 存放数据库，有过期时间
  >
  >   配置如下：
  >
  >   ```yaml
  >   management:
  >     security:
  >       enabled: false
  >   security:
  >     oauth2:
  >       resource:
  >         filter-order: 3
  >   ```
  >
  >4. 资源服务 （resource-service）
  >
  >   开启认证注解 （@EnableGlobalMethodSecurity(prePostEnabled = true)）
  >
  >   根据公钥，验证token有效性
  >
  >   配置如下：
  >
  >   ```yaml
  >   security:
  >     oauth2:
  >       resource:
  >         id: resource-service
  >         jwt:
  >           key-uri: http://localhost:8040/oauth/token_key
  >       client:
  >         client-id: webApp
  >         client-secret: webApp
  >         access-token-uri: http://localhost:8040/oauth/token
  >         grant-type: password
  >         scope: server
  >         user-authorization-uri: http://localhost:8040/oauth/authorize
  >   ```

+ 简单 token 方式 （guid  不带用户信息）

  >1. 认证服务 （auth2.0-center）
  >2. 资源服务（order-service）

+  