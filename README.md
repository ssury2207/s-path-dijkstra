# Dijkstra’s Algorithm – Shortest Path Finder

## Overview

Dijkstra’s Algorithm is a classic pathfinding algorithm used to find the shortest path from a **source node** to all other nodes in a **weighted graph** with **non-negative edge weights**.

It ensures that the shortest path is found by gradually building the minimum distance from the source to each node using a priority queue.

---

## How It Works

Dijkstra’s Algorithm follows these steps:

1. Assign a tentative distance value to every node:
   - `0` for the starting node
   - `∞` (infinity) for all others

2. Set the starting node as current and mark all others as unvisited.

3. For the current node, consider all its unvisited neighbors.  
   Calculate their tentative distances via the current node.

4. If the calculated distance is less than the known value, update it.

5. Mark the current node as visited. A visited node will not be checked again.

6. Select the unvisited node with the smallest tentative distance as the new current node, and repeat.

7. Stop when all nodes have been visited or the target has been reached.

---

## Key Properties

| Property           | Description                                        |
|--------------------|----------------------------------------------------|
| Type of graph      | Works on **weighted**, **connected** graphs        |
| Edge weights       | Must be **non-negative**                           |
| Optimality         | Always finds the **shortest path**                 |
| Time complexity    | `O((V + E) log V)` using a min-priority queue (heap) |

---

## Use Cases

- GPS and navigation systems
- Network routing protocols (e.g., OSPF)
- Shortest path calculations in maps and games
- Delivery and logistics route planning

---

## Limitations

- Cannot handle **negative edge weights**
- Slower than A* when searching from point A to a specific point B
- Explores all paths uniformly without direction

---

## Example Use Case

Suppose you're building a navigation tool and want to find the shortest routes from one city to all others in a transportation network:

- Nodes represent cities
- Edges represent roads with distance as weights
- Dijkstra efficiently provides shortest distances from the source city to all others

---

## Summary

- Dijkstra’s Algorithm is a foundational technique in graph theory and pathfinding.
- It is efficient and reliable for finding minimum distances in non-negative weighted graphs.
- It forms the basis for many real-world routing applications.

