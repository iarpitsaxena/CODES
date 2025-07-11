import
export default function Callback() {
    let a = function(){return 100};
    const[count,setCount] = useState(0);
    return (
        <div>
        < onClick = {()=> setCount(count+ 1)} > Counter: {count} />
        <Chotu kuch = {a} />
        </div>
    )
}

const Chotu = memo(function ({kuch}){
    return (
        <h1>Props:{kuch()}
        </h1>
    )
});