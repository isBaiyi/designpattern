# 设计模式
## 六大设计原则
- 单一职责原则：单一职责约定一个类应该有且仅有一个改变类的原因。
- 开闭原则：在面向对象编程领域中，开闭原则规定软件中的对象、类、模块和函数对扩展应该是开放的，但对于修改是封闭的。这意味着应该用抽象定义结构，用具体实现扩展细节，以此确保软件系统开发和维护过程的可靠性。
- 里氏替换原则：继承必须确保超类所拥有的性质在子类中仍然成立。
- 接口隔离原则：客户端不应该被迫依赖于它不使用的方法。该原则还有另外一个定义：一个类对另一个类的依赖应该建立在最小的接口上。
- 迪米特法则：迪米特法则（Law of Demeter，LoD）又称为最少知道原则（Least Knowledge Principle，LKP），是指一个对象类对于其他对象类来说，知道得越少越好。也就是说，两个类之间不要有过多的耦合关系，保持最少关联性。
- 依赖倒置原则：依赖倒置原则（Dependence Inversion Principle，DIP）是指在设计代码架构时，高层模块不应该依赖于底层模块，二者都应该依赖于抽象。抽象不应该依赖于细节，细节应该依赖于抽象。
## 创建型模式
### 原型模式
- 定义：原型模式（Prototype Pattern）是指原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。调用者不需要知道任何创建细节，不调用构造函数。
- 适用场景：
  - 类初始化消耗资源较多；
  - new 产生的一个对象需要非常繁琐的过程（数据准备、访问权限等）；
  - 构造函数比较复杂；
  - 循环体中生产大量的对象。
- 优点：
- 缺点：
  - 必须配备克隆或者可拷贝方法；
  - 对克隆复杂对象或对克隆出的对象进行复杂改造时，易带来风险；
  - 深拷贝、浅拷贝要合理运用。

### 单例模式
- 定义：单例模式（Singleton Pattern）是指保证一个类仅有一个实例，并提供一个访问它的全局访问点。单例模式主要分为两类：提前实例化（饿汉式）和延迟实例化（懒汉式）。
- 适用场景：确保任何情况下都绝对只有一个实例。
- 单例模式的常见写法：
  - 饿汉式单例：在单例类首次加载时就创建实例。
  - 懒汉式单例：被外部类调用时才创建实例。
  - 注册式（枚举）单例：将每一个实例都缓存到统一的容器中，使用唯一标识获取实例。
  - ThreadLocal 单例：对应单个线程来说，这是线程安全的，一般使用在数据源切换。
- 优点：
  - 在内存中只有一个实例，减少了内存开销；
  - 可以避免对资源的多重占用；
  - 设置全局访问点，严格控制访问。
- 缺点：
  - 没有接口，扩展困难。
  - 如果扩展单例对象，只有修改代码，没有其他途径。

### 工厂模式
#### 简单工厂模式
- 定义：简单工厂模式（Simple Factory Pattern）是指由一个工厂对象决定创建出哪一种产品类的实例。但是简单工厂不属于 GOF 23  设计模式。
- 适用场景：
  - 工厂类负责创建的对象较少。
  - 客户端只需要传入工厂类的参数，对于如何创建对象的逻辑不需要关心。
- 优点：只需传入一个正确的参数，就可以获取说需要的对象，无需知道其创建的细节。
- 缺点：
  - 工厂类的职责相对过重，增加新的产品时需要修改工厂类的判断逻辑，违背开闭原则。
  - 不易于扩展过于复杂的产品结构。

#### 工厂方法模式
- 定义：工厂方法模式（Factory Method Pattern）是指定义一个创建对象的接口，但让实现这个接口的类来决定实例化哪个类，工厂方法让类的实例化推迟到子类中进行。
- 适用场景：
  - 创建对象需要大量重复的代码；
  - 客户端（应用层）不依赖于产品类实例如何被创建、实现等细节；
  - 一个类通过其子类来指定创建哪个对象。
- 优点：
  - 用户只需要关心所需产品对应的工厂，无需关心创建细节；
  - 加入新产品符合开闭原则，提高了系统的可扩展性。
- 缺点：
  - 类的个数容易过多，增加了代码结构的复杂度；
  - 增加了系统的抽象性和理解难度。

#### 抽象工厂模式
- 定义：抽象工厂模式（Abstract Factory Pattern）是指提供一个创建一系列相关或相互依赖对象的接口，无需指定他们具体的类。
- 适用场景：
  - 客户端（应用层）不依赖于产品类实例如何被创建、实现等细节；
  - 强调一系列相关的产品对象（属于同一产品族）一起使用创建对象需要大量重复的代码；
  - 提供一个产品类的库，所有的产品以同样的接口出现，从而使客户端不依赖于具体实现。
  - 产品族：一系列的相关产品，整合到一起有关联性。
  - 产品等级：同一个继承体系。
- 优点：
  - 具体产品在应用层代码隔离，无需关心创建细节；
  - 将一个系列的产品族统一到一起创建。
- 缺点：
  - 规定了所有可能被创建的产品集合，产品族中扩展新的产品困难，需要修改抽象工厂的接口；
  - 增加了系统的抽象性和理解难度。



















