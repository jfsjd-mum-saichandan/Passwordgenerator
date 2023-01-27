const buttoncalled=document.getElementById("button");
buttoncalled.addEventListener('click', submit)
const getButtoncalled=document.getElementById("get");
getButtoncalled.addEventListener('click', get)

function submit(){
    let name1=document.getElementById("fname").value;
    let name2=document.getElementById("mname").value;
    let name3=document.getElementById("lname").value;
    let request = new Request('http://localhost:8080/registrations',{
        headers: new Headers({
            
            'Content-type': 'application/json'
        }),
        method: 'POST',
        body: JSON.stringify({
            "name": name1,
            "mname": name2,
            "lname": name3,
        })
});
function generatePassword(fname, mname, lname) {
    var password = fname.substring(0, 2) + mname.substring(0, 2) + lname.substring(0, 2)+Math.floor(Math.random() * 1000 );
    return password;
  }
fetch(request).then((response)=>{
    console.log(response);
    response.json().then((data)=>{
        console.log(data);
    })
})
    
    
   

}
async function get(){
    const response = await fetch('http://localhost:8080/registrations');
    
    // Storing data in form of JSON
    var data = await response.json();
    console.log(data);
    if(response){
        hideloader();
    }
    show(data);
}

    
get();
function hideloader() {
    document.getElementById('loading').style.display = 'none';
}

  

   


function show(data){
    let tab =
`<tr>
          <th>Name</th>
          
         </tr>`;
    
    // Loop to access all rows 
    for (let r of data) {
        tab += `<tr> 
    <td>${r.name} </td>
            
</tr>`;
    }
    // Setting innerHTML as tab variable
    document.getElementById("names").innerHTML = tab;
}
