'use strict';

function advanceGame() {
  let url = new URL(window.location);
  url.searchParams.set('game', WS.state['ScoreBoard.CurrentGame.Game']);
  window.location.replace(url);
}
