/**
 * 
 */
output = ''
for(let i=1 ; i<=5;i++){
	for(let b=1; b<=5-i;b++){
		output+=' '
	}
		for(let s=1;s<=i*2-1;s++){
			output+='*'
		}
	output+='\n'
}
for(let i=5 ; i>=1;i++){
	for(let b=0; b<5-i;b++){
		output+=' '
	}
		for(let s=1;s<=i*2-1;s++){
			output+='*'
		}
	output+='\n'
}