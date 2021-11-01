function register(){
	// jQueryのAjaxにてMemberControllerクラスのcreateメソッドを呼び出す
    $.ajax({
        url: "/crcup/register/data",
        dataType: "text",
        type: "POST",
		data: {
			country: $("#country").val(),
			team: $("#team").val(),
			leader: $("#leader").val(),
			memberA: $("#memberA").val(),
			memberB: $("#memberB").val(),
			coachA: $("#coachA").val(),
			coachB: $("#coachB").val(),
			coachC: $("#coachC").val()
		}
        // Ajaxが正常終了した場合
        }).done(function(data, textStatus, jqXHR) {
            // 該当するデータが無かった場合
            if(!data){
                alert("すべてのフォームを入力してください");
                return;
            }
            // idがregisterDataであるボタンを押したときにidがmsgのpタグにテキストを付与
			alert("データの登録が完了しました");
            // 画面のtableタグの全てのtrタグを削除
            $('#result').find("tr:gt(0)").remove();
            // 該当するデータがあった場合は、取得したMemberDataオブジェクトのリストを
            // 画面のtableタグに表示
            const userDataList = JSON.parse(data);
            let i = 0;
            for(i = 0; i < userDataList.length; i++){
                let trTag = $("<tr />");
                trTag.append($("<td></td>").text(userDataList[i].id));
				trTag.append($("<td></td>").text(userDataList[i].country));
				trTag.append($("<td></td>").text(userDataList[i].teamname));
				trTag.append($("<td></td>").text(userDataList[i].leader));
				trTag.append($("<td></td>").text(userDataList[i].memberA));
				trTag.append($("<td></td>").text(userDataList[i].memberB));
				trTag.append($("<td></td>").text(userDataList[i].coachA));
				trTag.append($("<td></td>").text(userDataList[i].coachB));
				trTag.append($("<td></td>").text(userDataList[i].coachC));
                $('#result').append(trTag);
            }
        // Ajaxが異常終了した場合
        }).fail(function(jqXHR, textStatus, errorThrown ) {
            alert("エラーが発生し、データが登録できませんでした");
    });
}
