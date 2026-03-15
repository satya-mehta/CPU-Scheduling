# FCFS CPU Scheduling Simulator (Java)

A Java-based simulator for the **First Come First Serve (FCFS)** CPU scheduling algorithm used in operating systems.
The program models process execution based on arrival time, calculates scheduling metrics, and generates a **console-based Gantt Chart** to visualize the CPU timeline.

---

## Overview

CPU scheduling is a fundamental concept in operating systems that determines which process gets access to the CPU.
The **First Come First Serve (FCFS)** algorithm executes processes in the order they arrive in the ready queue.

This simulator demonstrates how FCFS scheduling works by:

* Executing processes according to arrival time
* Handling CPU idle periods
* Tracking process execution order
* Computing scheduling metrics
* Displaying a **Gantt Chart timeline**

---

## Features

* Implementation of **FCFS scheduling algorithm**
* Process execution simulation
* **Turnaround Time calculation**
* **Waiting Time calculation**
* CPU **Idle Time handling**
* **Console-based Gantt Chart visualization**
* Colored console output for better readability

---

## Process Parameters

Each process contains the following attributes:

| Attribute       | Description                                      |
| --------------- | ------------------------------------------------ |
| Process ID      | Unique identifier of the process                 |
| Arrival Time    | Time at which the process enters the ready queue |
| Execution Time  | CPU burst time required by the process           |
| Turnaround Time | Completion Time − Arrival Time                   |
| Waiting Time    | Turnaround Time − Execution Time                 |

---

## Example Input

Processes defined in the program:

| Process | Arrival Time | Execution Time |
| ------- | ------------ | -------------- |
| P1      | 3            | 4              |
| P2      | 5            | 3              |
| P3      | 0            | 2              |
| P4      | 5            | 1              |
| P5      | 4            | 3              |

---

## Example Output

Execution Log:

```
 > > > Now Running P3 AT: 0, ET: 2, Time Now 2
 > > > Now Running P1 AT: 3, ET: 4, Time Now 7
 > > > Now Running P5 AT: 4, ET: 3, Time Now 10
 > > > Now Running P2 AT: 5, ET: 3, Time Now 13
 > > > Now Running P4 AT: 5, ET: 1, Time Now 14
```

Gantt Chart:

```
Gantt Chart:
| P3 | Idle | P1 | P5 | P2 | P4 |
0    2      3    7    10    13    14

```

Average metrics are displayed after execution.

---

## How the Scheduler Works

1. The simulator scans all processes to select the one with the **earliest arrival time** that has not yet executed.
2. If the CPU becomes free before the next process arrives, the CPU enters an **idle state**.
3. The selected process executes and updates the system time.
4. Turnaround time and waiting time are calculated.
5. Execution order is stored and used to generate the **Gantt Chart**.

---

## How to Run

### 1. Compile the program

```
javac Fcfs.java
```

### 2. Run the program

```
java Fcfs
```

---

## Concepts Demonstrated

This project helps illustrate key **Operating System scheduling concepts**:

* Process scheduling
* Ready queue behavior
* CPU idle handling
* Turnaround time
* Waiting time
* Scheduling visualization through Gantt charts

---

## Possible Improvements

Future extensions could include:

* Support for **Shortest Job First (SJF)**
* **Priority Scheduling**
* **Round Robin Scheduling**
* Dynamic user input for processes
* Graphical Gantt Chart visualization
* Improved data structures for larger simulations
* efficiency of the code can be improved by reducing the time complexity

---

## Author
### Satya Mehta

Created as a learning project to understand **CPU scheduling algorithms and process execution simulation in Java**.
