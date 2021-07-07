var app = angular.module('afishoSeminar', []);
app.controller('afishTegjithSeminaret', function($scope,$http) {

    $scope.initSeminar =  function(){
        $http.post('http://localhost:8080/pyetesor/user/list/seminaretemia')
            .then(function(res){
                $scope.seminars = res.data;

            });
    }

    $scope.initCategory =  function(){
        $http.post('http://localhost:8080/pyetesor/user/list/category')
            .then(function(res){
                $scope.categories = res.data;

            });
    }


    $scope.initPostimSeminar =  function(){
        $http.post('http://localhost:8080/pyetesor/user/list/postimetseminar')
            .then(function(res){
                $scope.postimetseminar = res.data;

            });
    }

    $scope.komento = function (postimId)
    {
        var a = document.getElementsByName(postimId);
        a[0].scrollIntoView();
        document.getElementById(postimId).focus();
    }


    $scope.fshiKoment = function (komentId) {
        {
            var testIdObject = "{\"komentId\":\""+komentId+"\"}";
            var obj = JSON.parse(testIdObject);
            var u = JSON.stringify(obj);
            $.ajax({//jquery form
                    url: 'http://localhost:8080/pyetesor/user/delete/koment',
                    type: "POST",
                    data: u,
                    dataType: 'JSON',
                    success: function (data, textStatus, xhr) {
                        $scope.initPostimSeminar();
                    },
                    error: function (xhr) {
                        if (xhr.status == 200) {
                            $scope.initPostimSeminar();
                        }
                    }

                }
            );

        }

    }

    $scope.shtoKoment = function (komentId) {
        {
            var koment = document.getElementById(komentId).value;
            var testIdObject = "{\"koment\":\""+koment+"\",\"komentId\":\""+komentId+"\"}";
            var obj = JSON.parse(testIdObject);
            var u = JSON.stringify(obj);
            $.ajax({//jquery form
                    url: 'http://localhost:8080/pyetesor/user/shto/koment',
                    type: "POST",
                    data: u,
                    dataType: 'JSON',
                    success: function (data, textStatus, xhr) {
                        $scope.initPostimSeminar();
                    },
                    error: function (xhr) {
                        if (xhr.status == 200) {
                            $scope.initPostimSeminar();
                        }
                    }

                }
            );

        }

    }


    $scope.shtoPostim = function (seminarId) {
        {
            var postim = document.getElementById("postim").value;
            var testIdObject = "{\"postim\":\""+postim+"\",\"seminarId\":\""+seminarId+"\"}";
            var obj = JSON.parse(testIdObject);
            var u = JSON.stringify(obj);
            $.ajax({//jquery form
                    url: 'http://localhost:8080/pyetesor/user/shto/postim',
                    type: "POST",
                    data: u,
                    dataType: 'JSON',
                    success: function (data, textStatus, xhr) {
                        $scope.initPostimSeminar();
                    },
                    error: function (xhr) {
                        if (xhr.status == 200) {
                            $scope.initPostimSeminar();
                        }
                    }

                }
            );

        }

    }

    $scope.fshiPostim = function (postimId) {
        {
            var testIdObject = "{\"postimId\":\""+postimId+"\"}";
            var obj = JSON.parse(testIdObject);
            var u = JSON.stringify(obj);
            $.ajax({//jquery form
                    url: 'http://localhost:8080/pyetesor/user/delete/postim',
                    type: "POST",
                    data: u,
                    dataType: 'JSON',
                    success: function (data, textStatus, xhr) {
                        $scope.initPostimSeminar();
                    },
                    error: function (xhr) {
                        if (xhr.status == 200) {
                            $scope.initPostimSeminar();
                        }
                    }

                }
            );

        }

    }

    $scope.shtoPerdorues = function () {
        {
            var username = document.getElementById("username").value;
            var testIdObject = "{\"username\":\""+username+"\"}";
            var obj = JSON.parse(testIdObject);
            var u = JSON.stringify(obj);
            $.ajax({//jquery form
                    url: 'http://localhost:8080/pyetesor/user/add/userseminar',
                    type: "POST",
                    data: u,
                    dataType: 'JSON',
                    success: function (data, textStatus, xhr) {
                    },
                    error: function (xhr) {
                        if (xhr.status == 200) {
                        }
                    }



                }
            );

        }

        alert("Perdoruesi u shtua me sukses");
        window.location.reload();

    }

    $scope.hiqPerdorues = function () {
        {
            var username = document.getElementById("username2").value;
            var testIdObject = "{\"username\":\""+username+"\"}";
            var obj = JSON.parse(testIdObject);
            var u = JSON.stringify(obj);
            $.ajax({//jquery form
                    url: 'http://localhost:8080/pyetesor/user/delete/userseminar',
                    type: "POST",
                    data: u,
                    dataType: 'JSON',
                    success: function (data, textStatus, xhr) {
                    },
                    error: function (xhr) {
                        if (xhr.status == 200) {
                        }
                    }



                }
            );

        }

        alert("Perdoruesi u hoq me sukses");
        window.location.reload();

    }

    $scope.largoPerdorues = function (username) {
        {
            var testIdObject = "{\"username\":\""+username+"\"}";
            var obj = JSON.parse(testIdObject);
            var u = JSON.stringify(obj);
            $.ajax({//jquery form
                    url: 'http://localhost:8080/pyetesor/user/delete/userseminar',
                    type: "POST",
                    data: u,
                    dataType: 'JSON',
                    success: function (data, textStatus, xhr) {
                    },
                    error: function (xhr) {
                        if (xhr.status == 200) {
                        }
                    }



                }
            );

        }

        alert("Perdoruesi u hoq me sukses");
        window.location.reload();

    }


    $scope.fshiSeminar = function (seminarId) {
        {

            var testIdObject = "{\"seminarId\":\""+seminarId+"\"}";
            var obj = JSON.parse(testIdObject);
            var u = JSON.stringify(obj);
            $.ajax({//jquery form
                    url: 'http://localhost:8080/pyetesor/user/delete/seminaret',
                    type: "POST",
                    data: u,
                    dataType: 'JSON',
                    success: function (data, textStatus, xhr) {
                        $scope.initPostimSeminar();
                    },
                    error: function (xhr) {
                        if (xhr.status == 200) {
                            $scope.initPostimSeminar();
                        }
                    }

                }
            );

        }

        alert("Kursi u fshi me sukses!");
        window.location.reload(true);

    }




});
