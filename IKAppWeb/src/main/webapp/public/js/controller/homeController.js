app.controller('HomeController',function($scope){
	
	$scope.todos = [
	                {id:1,comment:'Todo-1',done:false},
	                {id:2,comment:'Todo-2',done:true},
	                {id:3,comment:'Todo-3',done:false}
	                
	                ];
	

	$scope.addTodo = function(){
		if ($scope.comment) {
			var id = 1;
			if($scope.todos.length > 0){
				id = $scope.todos[$scope.todos.length-1].id + 1;
			}
			
			$scope.todos.push({id:id,comment:$scope.comment,done:false});
			$scope.comment = '';
		}
		
	};
	
	$scope.taskMarkAll = function(){
		angular.forEach($scope.todos,function(todo){
			todo.done = $scope.markAll;
		});
	}
	
	$scope.isTodo = function(){
		return $scope.todos.length > 0 ? true : false;
	}
	
	
	$scope.remaining= function(){
		var count = 0;
		
		angular.forEach($scope.todos,function(todo){
			
			if (!todo.done) {
				count += 1;
			}
			
		});
		
		return count
	}
	
	$scope.clear = function(){
		var oldTodos = $scope.todos;
		
		 $scope.todos = [];
		 
		 angular.forEach(oldTodos, function(todo) {
		      if (!todo.done) $scope.todos.push(todo);
		    });
		 
		 $scope.markAll = false;
	}
	
	$scope.hasDone = function(){
		return ($scope.todos.length != $scope.remaining());
	}
	
	$scope.updateTodo= function(index){
		if ($scope.tempComment) {
			$scope.todos[index].comment = tempComment;
			$scope.tempComment = '';
		}
		
	}
	
	 $scope.editMode = function(){
	      $(event.target).closest('li').toggleClass('editing');
	  };
	  $scope.editOnEnter = function(todo){
	      if(event.keyCode == 13 && todo.comment){
	          $scope.editMode();
	      }
	  };
});