import random
def randompartition(arr,low,high):
	i=low-1
	rno=random.randint(low,high)
	arr[high],arr[rno]=arr[rno],arr[high]
	pivot=arr[high]

	for j in range(low,high):
		if(pivot>arr[j]):
			i=i+1
			arr[i],arr[j]=arr[j],arr[i]
	i=i+1
	arr[high],arr[i]=arr[i],arr[high]
	return i

def deterministic(arr,low,high):
	i=low-1
	pivot=arr[high]
	for j in range(low,high):
		if(pivot>arr[j]):
			i=i+1
			arr[i],arr[j]=arr[j],arr[i]
	i=i+1
	arr[high],arr[i]=arr[i],arr[high]
	return i

def quicksort(arr,low,high,method):
	if low<high:
		if method=="random":
			pidx=randompartition(arr,low,high)
		else:
			pidx=deterministic(arr,low,high)
		quicksort(arr,low,pidx-1,method)
		quicksort(arr,pidx+1,high,method)

arr=[5,4,6,3,7,1]
print(arr)
quicksort(arr,0,len(arr)-1,"random")
print(arr)
quicksort(arr,0,len(arr)-1,"deterministic")
print(arr)