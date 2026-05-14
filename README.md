<img width="1152" height="650" alt="image" src="https://github.com/user-attachments/assets/9f693eb7-5b2b-4c26-92dc-b2f0e9034e84" />
<img width="1491" height="656" alt="image" src="https://github.com/user-attachments/assets/cbd7dd6b-d55f-4a0c-9ed5-6b2bca9d4af4" />
<img width="1475" height="619" alt="image" src="https://github.com/user-attachments/assets/6d782053-8d4a-48a0-930b-509d79aaad49" />
<img width="1493" height="628" alt="image" src="https://github.com/user-attachments/assets/a4db6f7d-e42c-40c7-bb13-f4f51258f2f2" />
<img width="1491" height="625" alt="image" src="https://github.com/user-attachments/assets/31dc3280-46ce-47f1-bc8c-84ab8d535967" />
<img width="1497" height="636" alt="image" src="https://github.com/user-attachments/assets/d0121aac-7bb4-4f0a-a447-22248ac6791d" />
<img width="1475" height="641" alt="image" src="https://github.com/user-attachments/assets/2e283873-52c8-4343-94d0-c0123306af00" />
<img width="1499" height="633" alt="image" src="https://github.com/user-attachments/assets/2d4a66d8-19a8-401d-917f-e659883ce28b" />
<img width="1919" height="1070" alt="image" src="https://github.com/user-attachments/assets/96a9f352-f7e8-4c53-8cea-1c6a10e710c2" />

📌 Project OverviewThis project focuses on the implementation of graph data structures and traversal algorithms in Java. The goal is to represent a graph using an Adjacency List and perform efficient searching using Breadth-First Search (BFS) and Depth-First Search (DFS) algorithms. The project also includes a performance analysis section to compare the efficiency of these algorithms across different graph sizes.

🛠 Core Components
1. Data Structures
Vertex: Represents a node in the graph with a unique identifier.
Edge: Represents a connection between a source vertex and a destination vertex.
Graph: The main container that implements the Adjacency List using a Map<Integer, List<Integer>>.

2. AlgorithmsBreadth-First Search (BFS): Explores the graph layer by layer. It uses a Queue (FIFO) to visit neighbors first.Complexity:$O(V + E)$
1. Depth-First Search (DFS): Explores the graph by going as deep as possible before backtracking. It uses Recursion (Stack-based logic).Complexity: $O(V + E)$

BFS vs DFSBFS is superior for finding the shortest path in unweighted graphs because it explores all nodes at distance $k$ before moving to $k+1$.DFS is more suitable for tasks like cycle detection and topological sorting. It is easier to implement recursively but can lead to StackOverflow on extremely deep graphs.
