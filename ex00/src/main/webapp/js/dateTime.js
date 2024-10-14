/**
 * 
 */

function toDate(timeStamp, separChar) {
	
	if (!separChar) separChar = "-";
	 
	let dateObj = new Date(timeStamp);
	let yy = dateObj.getFullYear();
	let mm = dateObj.getMonth();
	let dd = dateObj.getDate();
	console.log(yy+ "-" + mm+ "-" +dd);
	return yy + separChar + 
		(mm > 9 ? "" : "0") + mm + separChar +
		(dd > 9 ? "" : "0") + dd;
	
}

function toTime(timeStamp) {
	let dateObj = new Date(timeStamp);
	let hh = dateObj.getHours();
	let mi = dateObj.getMinutes();
	let ss = dateObj.getSeconds();
	return (hh > 9 ? "" : "0") + hh + ":" + 
		(mi > 9 ? "" : "0") + mi + ":" +
		(ss > 9 ? "" : "0") + ss;
}


//24시간이 지나면 날짜 지나지 않았으면 시간
function toDateTime(timeStamp) {
	
	let today = new Date();
	
	let gap = today.getTime() - timeStamp;
	
	if (gap < (1000*60*60*24)) return toTime(timeStamp);
	else return toDate(timeStamp);
	
}