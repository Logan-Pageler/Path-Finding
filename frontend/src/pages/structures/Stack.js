/**
 * Stack Page Component. Makes requests
 * to the /stack endpoint of the API.
 * 
 * @author Logan Pageler
 */
import { Button, TextField } from "@mui/material";
import React from "react";


function Stack() {

    const [expression, setExpression] = React.useState("");
    const [output, setOutput] = React.useState("hello");

    function handleChange(event) {
        setExpression(event.target.value);
    }

    function handleClick() {
        fetch(`http://localhost:8080/stack?` + new URLSearchParams({
            expression
    }))
        .then((res) => {
            res.text().then(function(responseString) { 
                setOutput(responseString);
            });
        })
    }

    return (
        <>
            <h1> Stacks </h1>
            <p>
                Stacks can be used to solve expressions. <br />
                Feel free to try it out bellow by inserting <br />
                mathmatical expressions using '+', '-', '\', <br />
                '*', '(', ')'.
            </p>
            <TextField
            variant="filled"
            onChange={handleChange}
            >

            </TextField>
            <Button onClick={handleClick}>
                Solve
            </Button>
            <p>
                Output: {output}
            </p>

        </>
    );
}

export default Stack;