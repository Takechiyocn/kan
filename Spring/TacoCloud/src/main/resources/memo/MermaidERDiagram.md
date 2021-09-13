### ER图

Mermaid使用鸭掌模型(crow's foot notation)定义

* 基本语法

      <first-entity> [<relationship> <second-entity> : <relationship-label>]

* 关系relationship

|Value(left)|Value(right)|Meaning|
|:--:|:--:|:--|
|&#124;o|o&#124;|Zero or one|
|&#x7C;&#x7C;|&#x7C;&#x7C;|Exactly one|
|}o|o{|Zero or more(no upper limit)|
|}&#124;|&#124;{|one or more(no upper limit)|


```mermaid
erDiagram
  A1 |o--|o B1 : "0或1:0或1" 
  A2 ||--|| B2 : "1:1" 
  A3 ||--o{ B3 : "1:n(n>=0)" 
  A4 ||--|{ B4 : "1:n(n>=1)" 
  A5 |{--|{ B5 : "n:n(n>=1)"
```

* 属性

```mermaid
erDiagram
  CAR ||--o{ NAMED-DRIVER : allows
  CAR {
    string registrationNumber
    string make
    string model
  }
  PERSON ||--o{ NAMED-DRIVER : is
  PERSON {
    string firstName
    string lastName
    int age
  }
  PERSON }|..|{ DELIVERY-ADDRESS : uses
```


[comment]: <> (TODO:style)

[comment]: <> (style CAR fill:#f9f,stroke:#333,stroke-width:4px)

[comment]: <> (style PERSON fill:#ccf,stroke:#f66,stroke-width:2px,stroke-dasharray: 5, 5)
