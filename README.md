# home-spring
1) insert lombok dependency to pom.xml (To use @NoArgsConstructor,@AllArgsConstructor,@Data)
2) <BeanConfiguration.java> @Configuration 
3) <insert.jsp> jquery cdn (<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>)
4) <BoardController.java> @GetMapping(value = "insert.do") -> @PostMapping(value = "insert.do")
5) <view.jsp> jquery cdn (<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>)
6) <board.xml> board -> BoardDAO <mapper namespace="com.koreait.test1.dao.board"> -> <mapper namespace="com.koreait.test1.dao.BoardDAO">
7) <board.xml> select id="selectBoardCount" resultType="int" 추가
  <select id="selectBoardCount" resultType="int">
		SELECT COUNT(*)
		  FROM BOARD
	</select>
8) <list.jsp> bIdx -> BIdx 나머지 변수도 마찬가지로 수정
	<tr>
		<td>${boardDTO.BIdx}</td>
		<td>${boardDTO.BWriter}</td>
		<td><a href="selectBoardByIdx.do?bIdx=${boardDTO.BIdx}">${boardDTO.BTitle}</a></td>
		<td>${boardDTO.BDate}</td>
	</tr>
9) <view.jsp> bIdx -> BIdx 나머지 변수도 마찬가지로 수정
