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

    $scope.initPostim =  function(){
        $http.post('http://localhost:8080/pyetesor/user/list/postimetemia')
            .then(function(res){
                $scope.posts = res.data;

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

    $scope.cregjistrohu = function (seminarId) {
        {
            var testIdObject = "{\"seminarId\":\""+seminarId+"\"}";
            var obj = JSON.parse(testIdObject);
            var u = JSON.stringify(obj);
            $.ajax({//jquery form
                    url: 'http://localhost:8080/pyetesor/user/delete/seminar',
                    type: "POST",
                    data: u,
                    dataType: 'JSON',
                    success: function (data, textStatus, xhr) {
                        alert("testi u fshi me " + textStatus);
                        $scope.initSeminar();
                    },
                    error: function (xhr) {
                        if (xhr.status == 200) {
                            alert("gabim");
                            $scope.initSeminar();
                        }
                    }

                }
            );

        }

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
                        $scope.initPostim();
                    },
                    error: function (xhr) {
                        if (xhr.status == 200) {
                            $scope.initPostim();
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
                        $scope.initPostim();
                    },
                    error: function (xhr) {
                        if (xhr.status == 200) {
                            $scope.initPostim();
                        }
                    }

                }
            );

        }

    }




});
