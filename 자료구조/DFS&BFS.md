# DFS&BFS

### 탐색
많은 양의 데이터 중에서 원하는 데이터를 찾는 과정

### 자료구조
데이터를 표현하고 관리하고 처리하기 위한 구조

* push: 데이터 삽입
* pop: 데이터 삭제
* 오버플로: 특정 자료구조가 수용할 수 있는 데이터의 크기를 이미 가득 찬 상태에서 삽입연산 수행시 발생
* 언더플로: 데이터가 전혀 들어 있지 않는 상태에서 삭제 연산을 수행하면 발생

#### 기본 자료구조

1. 스택
- 선입후출의 구조 또는 후입 선출의 구조라 한다.<br>
``` 
import java.util.Stack; //import
Stack<Integer> stack = new Stack<>(); //int형 스택 선언
Stack<String> stack = new Stack<>(); //char형 스택 선언
```
```
stack.push(1);     // stack에 값 1 추가
stack.push(2);     // stack에 값 2 추가
stack.push(3);     // stack에 값 3 추가
stack.pop();       // stack에 값 제거
stack.clear();     // stack의 전체 값 제거 (초기화)
```
```
stack.size();      // stack의 크기 출력 : 2
stack.empty();     // stack이 비어있는제 check (비어있다면 true)
stack.contains(1) // stack에 1이 있는지 check (있다면 true)
``` 

2. 큐
- 선입선출의 구조
- 그래프 넓이 우선 탐색(BFS)에 주로 사용
``` 
import java.util.LinkedList; //import
import java.util.Queue; //import
Queue<Integer> queue = new LinkedList<>(); //int형 queue 선언, linkedlist 이용
Queue<String> queue = new LinkedList<>(); //String형 queue 선언, linkedlist 이용
```
```
Queue<Integer> queue = new LinkedList<>(); //int형 queue 선언
queue.offer(1);     // queue에 값 1 추가
queue.offer(2);     // queue에 값 2 추가
queue.offer(3);     // queue에 값 3 추가
queue.poll();       // queue에 첫번째 값을 반환하고 제거 비어있다면 null
queue.remove();     // queue에 첫번째 값 제거
queue.clear();      // queue 초기화
```
```
queue.peek();       // queue의 첫번째 값 참조
```

📌우선순위 큐
  : PriorityQueue는 먼저 들어온 순서대로 데이터가 나가는 것이 아닌 우선순위를 먼저 결정하고,그 우선순위가 높은 엘리먼트가 먼저 나가는 자료구조<br>
  : 우선순위 큐는 힙을 이용하여 구현하는 것이 일반적
  : 데이터를 삽입할 때 우선순위를 기준으로 최대힙 혹은 최소 힙을 구성하고, <br>
    데이터를 꺼낼 때 루트 노드를 얻어낸 뒤 루트 노드를 삭제할 때는 빈 루트 노드 위치에 맨 마지막 노드를 삽입한 후 아래로 내려가면서 적절한 자리를 찾아서 옮기는 방식으로 진행

```
import java.util.PriorityQueue; //import

//int형 priorityQueue 선언 (우선순위가 낮은 숫자 순)
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

//int형 priorityQueue 선언 (우선순위가 높은 숫자 순)
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

//String형 priorityQueue 선언 (우선순위가 낮은 숫자 순)
PriorityQueue<String> priorityQueue = new PriorityQueue<>(); 

//String형 priorityQueue 선언 (우선순위가 높은 숫자 순)
PriorityQueue<String> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
```
```
priorityQueue.add(1);     // priorityQueue 값 1 추가
priorityQueue.add(2);     // priorityQueue 값 2 추가
priorityQueue.offer(3);   // priorityQueue 값 3 추가

priorityQueue.poll();       // priorityQueue에 첫번째 값을 반환하고 제거 비어있다면 null
priorityQueue.remove();     // priorityQueue에 첫번째 값 제거
priorityQueue.clear();      // priorityQueue에 초기화
```
```
priorityQueue.peek();       // priorityQueue에 첫번째 값 참조

```

3. 재귀함수
- 자기 자신을 다시 호출하는 함수


### DFS
깊이 우선 탐색<br>
그래프의 깊은 부분을 우선적으로 탐색하는 알고리즘

* 인접행렬: 2차원배열로 그래프의 연결관계를 표현하는 방식
* 인접리스트: 리스트로 그래프의 연결관계를 표현하는 방식

#### 구현방법
1. 탐색시작 노드를 스택에 삽입하고 방문처리한다.
2. 스택의 최상단 노드에 방문하지 않은 노드가 있으면 그 인접노드를 스택에 넣고 방문처리를 한다.<br>
   방문하지 않은 인접노드가 없으면 스택에서 최상단 노드를 꺼낸다.
3. 2번의 과정을 더이상 수행할 수 없을때까지 반복한다.

```
public class Study_DFS_Recursion {

	// 방문처리에 사용 할 배열선언
	static boolean[] vistied = new boolean[9];
	
	// 그림예시 그래프의 연결상태를 2차원 배열로 표현
	// 인덱스가 각각의 노드번호가 될 수 있게 0번인덱스는 아무것도 없는 상태라고 생각하시면됩니다.
	static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
	
	public static void main(String[] args) {
		dfs(1);
	}
	
	static void dfs(int nodeIndex) {
		// 방문 처리
		vistied[nodeIndex] = true;
		
		// 방문 노드 출력
		System.out.print(nodeIndex + " -> ");
		
		// 방문한 노드에 인접한 노드 찾기
		for (int node : graph[nodeIndex]) {
			// 인접한 노드가 방문한 적이 없다면 DFS 수행
			if(!vistied[node]) {
				dfs(node);
			}
		}
	}
}

```

### BFS
너비 우선 탐색<br>
가까운 노드부터 탐색하는 알고리즘

#### 구현방법
1. 탐색 시작노드를 큐에 삽입하고 방문 처리한다.
2. 큐에서 노드를 꺼내 해당 노드의 인접 노드중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문처리한다.
3. 2버의 과정을 더이상 수행할수 없을 때까지 반복한다.

```
public class StudyBFS {
	
	public static void main(String[] args) {
		
		// 그래프를 2차원 배열로 표현해줍니다.
		// 배열의 인덱스를 노드와 매칭시켜서 사용하기 위해 인덱스 0은 아무것도 저장하지 않습니다.
		// 1번인덱스는 1번노드를 뜻하고 노드의 배열의 값은 연결된 노드들입니다.
		int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
		
		// 방문처리를 위한 boolean배열 선언
		boolean[] visited = new boolean[9];
		
		System.out.println(bfs(1, graph, visited));
		//출력 내용 : 1 -> 2 -> 3 -> 8 -> 6 -> 5 -> 4 -> 7 -> 
	}
	
	static String bfs(int start, int[][] graph, boolean[] visited) {
		// 탐색 순서를 출력하기 위한 용도
		StringBuilder sb = new StringBuilder();
		// BFS에 사용할 큐를 생성해줍니다.
		Queue<Integer> q = new LinkedList<Integer>();
		 
		// 큐에 BFS를 시작 할 노드 번호를 넣어줍니다.
		q.offer(start);
		
		// 시작노드 방문처리
		visited[start] = true;
		
		// 큐가 빌 때까지 반복
		while(!q.isEmpty()) {
			int nodeIndex = q.poll();
			sb.append(nodeIndex + " -> ");
			//큐에서 꺼낸 노드와 연결된 노드들 체크
			for(int i=0; i<graph[nodeIndex].length; i++) {
				int temp = graph[nodeIndex][i];
				// 방문하지 않았으면 방문처리 후 큐에 넣기
				if(!visited[temp]) {
					visited[temp] = true;
					q.offer(temp);
				}
			}
		}
		// 탐색순서 리턴
		return sb.toString() ;
	}
}

```

















