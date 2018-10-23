$(function(){
    // -------------------------LISTAR----------------------------------------
    $('#btn-listar').click(function() { 
       $('#container').load('listar.html', function(){ 
        var cidade = "Araraquara"


         $.get('http://localhost:8080/clima/'+ cidade, function (dados) {
        dados.forEach(i => {
            var txcidade =    $('<h2></h2>').html(i.cidade);
            var txdata =      $('<h4></h4>').html(i.data);
            var txtempMin =   $('<label></label>').html(i.cpf);
            var txtempMax =   $('<label></label>').html(i.tempMax);
            var txPressao =   $('<label></label>').html(i.Pressao);
            var txUmidade =   $('<label></label>').html(i.Umidade);
            var txVento =     $('<label></label>').html(i.Vento);

            var tr = $('<div></div>').append(txcidade)
                                    .append(txdata)
                                    .append(txtempMin)
                                    .append(txtempMax)
                                    .append(txPressao)
                                    .append(txUmidade)
                                    .append(txVento)

            $('#container').append(tr);                        
            });
        });
     });
    });
});

