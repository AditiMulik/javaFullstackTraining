node{
	def mvnHome
	def dockerHome
	stage('Checkout'){
		git url: 'https://github.com/AditiMulik/javaFullstackTraining/', branch: 'jenkinsTrial'
		mvnHome = tool 'MyMaven'
		dockerHome = tool 'MyDocker'
	}
	
	stage('Build'){
		bat(/"${mvnHome}\bin\mvn" clean package/)
	}
	
	stage('Containerize'){
		bat(/"${dockerHome}\Docker\resources\bin\docker" build -t auto-trial1:latest ./)
	}
}
