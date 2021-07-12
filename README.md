# home-spring
1) insert lombok dependency to pom.xml (To use @NoArgsConstructor,@AllArgsConstructor,@Data)
2) <BeanConfiguration.java> @Configuration 
3) <insert.jsp> jquery cdn (<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>)
4) <BoardController.java> @GetMapping(value = "insert.do") -> @PostMapping(value = "insert.do")
5) <view.jsp> jquery cdn (<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>)
6) <board.xml> <mapper namespace="com.koreait.test1.dao.board"> -> <mapper namespace="com.koreait.test1.dao.BoardDAO">
7) 
