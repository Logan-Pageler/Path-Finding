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
    const [output, setOutput] = React.useState("");

    function handleChange(event) {
        setExpression(event.target.value);
    }

    function handleClick() {
        fetch(`http://174.138.108.50:8080/stack?` + new URLSearchParams({
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
            <p className="description">
                &emsp;&emsp;Stacks are a data structures that allow for only the most
                recently added element to be accessed. Think of it like a 
                pancake stack. Pancakes will always be added to the top of
                the stack as they come off the pan. Then Each pancake will 
                be eaten from the top down, with the most recently added
                eaten first.
                <br />

                &emsp;&emsp;Because of their simple natures stacks are quite fast.
                Viewing the top element of the stack runs in O(1).
                Removing and adding to the stack is typically amortized
                O(1).
            </p>
            <br/>

            <p className="description">
                Stacks have many uses, one of which is to solve expressions. <br />
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