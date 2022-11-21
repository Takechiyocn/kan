### 1.Mermaid流程图

```mermaid
	graph TB
	A[Apple]-->B{Boy}
	A---C(Cat)
	B.->D((Dog))
	C==喵==>D
	style A fill:#2ff,fill-opacity:0.1,stroke:#faa,stroke-width:4px
	style D stroke:#000,stroke-width:8px;
```

### 2.TODO:PUML

```puml
@startuml
    st=>start: 开始
    e=>end: 结束
    op1=>operation: 操作1 | past
    op2=>operation: 操作2 | current
    op3=>operation: 操作3 | future
    pa=>parallel: 多输出操作4 | approved
    cond=>condition: 确认？ | rejected
    st->op1->cond
    cond(true)->e	
    cond(no)->op2(right)->op3->pa(path1,right)->op1
    pa(path2,left) ->e
    st@>op1({"stroke":"Blue"})@>cond({"stroke":"Green"})@>e({"stroke":"Red","stroke-width":6,"arrow-end":"classic-wide-long"})
@enduml
```

### 3.时序图

```mermaid
    sequenceDiagram
    participant 张 as 张三
    participant 李 as 李四
    participant 王 as  王五   
    张 ->> +李: 你好！李四, 最近怎么样?
    李-->> 王: 你最近怎么样，王五？
    李--x -张: 我很好，谢谢!
    activate 王
    李-x 王: 我很好，谢谢!   
    Note over 李,王: 李四想了很长时间, 文字太长了<br/>不适合放在一行.
    deactivate 王
    loop 李四再想想
    李-->>王: 我还要想想
    王-->>李: 想想吧
    end
    李-->>张: 打量着王五...
    张->>王: 很好... 王五, 你怎么样?
```

