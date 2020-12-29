node{
	def mvnHome
	def dockerHome
	stage('Checkout'){
		git url: 'https://github.com/AditiMulik/javaFullstackTraining/', branch: 'jenkinsTrial'
		mvnHome = tool 'MyMaven'
	}
	
	stage('Build'){
		bat(/"${mvnHome}\bin\mvn" clean package/)
	}
}
