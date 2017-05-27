$(document).ready(function (){
	$("#formInserir").validate(); 
	var inputFone = document.getElementById("telefone");
	var mascaraFone = new Inputmask("(99)9999-9999");
	mascaraFone.mask(inputFone);
	
	var inputNascimento = document.getElementById("dataNascimento");
	var mascaraDataNascimento = new Inputmask("99/99/9999");
	mascaraDataNascimento.mask(inputNascimento);
	
	
});