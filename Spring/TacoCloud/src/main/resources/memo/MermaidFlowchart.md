### Mermaid语法

流程图：graph或graph（github支持graph）

```mermaid
graph LR
subgraph Title
style A fill:#f9f,stroke:#333,stroke-width:4px
style E fill:#ccf,stroke:#f66,stroke-width:2px,stroke-dasharray: 5, 5
A(Start)
A --> B[Look for an item]
B --> C{Did you find it?}
C -->|Yes| D(Stop looking)
C -->|No| E{Do you need it?}
E -->|Yes| B
E -->|No| D
end
```
#### mermaid流程图

* 节点组织
    * TB - top to bottom
    * TD - top-down/ same as top to bottom
    * BT - bottom to top
    * RL - right to left
    * LR - left to right

* 节点nodes

```mermaid
graph
subgraph 节点组织
    1.默认节点无替代
    id1[1.矩形节点]
    id2(2.圆角矩形节点:round edges)
    id3([3.体育场形状:stadium-shaped])
    id4[(4.圆柱形节点:cylindrical edges)]
    id5[[5.矩形嵌套节点:subroutine shape]]
    id6((6.圆:circle))
    id7->7.不对称节点:asymmetric shape]
    id8{8.菱形节点:rhombus}
    id9{{9.六边形节点:hexagon}}
    id10[/10.平行四边形:hexagon/]
    id11[\11.逆平行四边形:hexagon\]
    id12[/12.梯形节点:hexagon\]
    id13[\13.逆梯形节点:hexagon/]
end
```

#### 链接links

* 箭头链接arrow links
```mermaid
graph LR
    A1 --> B1
    A2 -- text -->B2
    A3 --> |text| B3
    A4 --o B4
    A5 o--o B5
    A6 --x B6
    A7 x--x B7
    A8 <--> B8
```
  
* 开放链接open links
```mermaid
graph LR
    A1 --- B1
    A2 -- text --- B2
    A3 ---| text | B3
    A4 --- text --- B4
```
  
* 虚线链接dotted links
```mermaid
graph LR
    A1 -.->B1
    A2 -. text .->B2
```

* 加粗线链接thick links
```mermaid
graph LR
    A1 ==> B1
    A2 == text ==> B2
```
  
#### 链接链
```mermaid
graph LR
    A -- text --> B -- text2 --> C
    A1 --> B1 & C1 --> D1
    A2 & B2 --> C2 & D2
```
```mermaid
graph TB
    A --> C
    A --> D
    B --> C
    B --> D
```

#### 链接长度
```mermaid
graph TB
    A[Start] --> B{Is it?};
    B --> |Yes| C[OK];
    C --> D[Rethink];
    D --> B;
    B --> |No| E[End];
```
* 链接长度

![linklength.png](mermaid/graph/MermaidGraphLinklength.png)