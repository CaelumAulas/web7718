<%@attribute name="id"%>

<input type="text" name="${id}" id="${id}">

<script>
	$("#${id}").datepicker({
		dateFormat : 'dd/mm/yy'
	}).on('click', function(e){
		e.preventDefault();
		$(this).attr("autocomplete", "off");
	});
</script>