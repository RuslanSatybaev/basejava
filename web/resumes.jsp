<html>
<body>
<h2>All Resumes</h2>
<br>
<table>
    <tr>
        <th>Name</th>
        <th>Uuid</th>
    </tr>
        <tr>
            <td>${name}</td>
            <td>${uuid}</td>
            <td>
                <input type="button" value="Update"
                       onclick="window.location.href='${updateButton}'"/>

                <input type="button" value="Delete"
                       onclick="window.location.href='${deleteButton}'"/>
            </td>
        </tr>
</table>

<br>

<input type="button" value="Add"
       onclick="window.location.href='addNewEmployee'">

</body>
</html>