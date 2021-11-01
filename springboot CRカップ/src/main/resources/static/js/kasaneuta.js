// 画面表示時、ID"youtube-area"の要素にclass"apear"を設定
$(window).on('load', function(){
	$('#youtube-area').addClass('appear');
});
// YouTubeAPIが設定されたscriptタグをHTML上のscriptタグ内で一番上に作成
// scriptタグを作成
var tag = document.createElement('script');
// scriptタグのsrc属性にAPIのURLを指定
tag.src = "https://www.youtube.com/iframe_api";
// HTML上のscriptタグをすべて取得した後。0番目の要素を取得
var firstScriptTag = document.getElementsByTagName('script')[0];
// 一番上のscriptタグの直前に追加
firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

// 変数作成
var ytPlayer;
// YouTubeAPIを読み込んで、使用できるようになったら、動くイベント
function onYouTubeIframeAPIReady(){
    // インスタンス化
    // YT.Player(再生する方法、オプション)
    // JSONでデータを格納
    ytPlayer = new YT.Player('youtube', {

        // 再生したい動画のIDを指定
        videoId: '6pCyiTzUsTw',
        // 再生する動画の詳細設定
        playerVars:{
            playsinline: 1, // インライン来栖にする（設定しないと、0:全画面）
            autoplay: 1, // 自動再生を行う（0:自動再生なし）
            fs: 0, // 全画面表示ボタンを表示しない（1:表示する）
            rel: 0, // 関連動画の表示を行わない（1:表示しない）
            controls: 0, // コントロールバーを表示しない（1:表示、2:再生後に表示）
            modestbranding:1, // YouTubeロゴを非表示
            iv_load_policy: 3, // 動画上で押下できるテキストを非表示（1:表示、3:非表示）
            start: 0, // 0秒後から動画を再生
        },
        // イベントの設定
        events: {
            // 再生できるようになったら動く処理 
            'onReady': onPlayerReady,
            // 再生している動画の状態が変わったら、動く処理
            'onStateChange': onPlayerStateChange
        }
    });
}
function onPlayerReady(event){
    // ミュート
    event.target.mute();
    // 再生
    event.target.playVideo();
}
function onPlayerStateChange(event){
    // 動画が終わっていたら動く処理
    if(event.data == YT.PlayerState.ENDED){
        // 再生
        event.target.playVideo();
    }
}