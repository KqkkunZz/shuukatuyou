function allDataGet(){
	// jQueryのAjaxにてMemberControllerクラスのsearchAllメソッドを呼び出す
    $.ajax({
        url: "/crcup/all",
        dataType: "text",
        type: "GET"
        // Ajaxが正常終了した場合
        }).done(function(data, textStatus, jqXHR) {
            // 該当するデータが無かった場合
            if(!data){
                alert("該当するデータはありませんでした");
                return;
            }
            // 画面のtableタグの全てのtrタグを削除
            $('#result').find("tr:gt(0)").remove();
            // 該当するデータがあった場合は、取得したMemberオブジェクトのリストを
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
            alert("エラーが発生し、データが取得できませんでした");
    });
}

function selectDataGet(){
	// jQueryのAjaxにてMemberControllerクラスのsearchメソッドを呼び出す
    $.ajax({
        url: "/crcup/search",
        dataType: "text",
        type: "POST",
		data: {
			searchId: $("#searchId").val(),
			teamName: $("#teamSearch").val(),
			country: $("#countrySearch").val()
		}
        // Ajaxが正常終了した場合
        }).done(function(data, textStatus, jqXHR) {
            // 該当するデータが無かった場合
            if(!data){
                alert("該当するデータはありませんでした");
                return;
            }
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
            alert("エラーが発生し、データが取得できませんでした");
    });
}
