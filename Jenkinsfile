node{
	def mvnHome
	def dockerHome
	stage('Checkout'){
		git url: 'file://E:/Well-Fargo4/Wave2/Group6/WorkSpace/bootapp-restful', branch: 'master'
		mvnHome = tool 'Local Maven'
		dockerHome = tool 'MyDocker'
	}
	
	stage('Build'){
		bat(/"${mvnHome}\bin\mvn" clean package/)
	}
	
	stage('Containerize"){
		bat(/"${dockerHome}\Docker\resources\bin\docker" build -t auto-restful-app:latest ./)
	}
}