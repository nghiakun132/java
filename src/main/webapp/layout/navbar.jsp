<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
        <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">SB Admin <sup>2</sup></div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - Dashboard -->
    <li class="nav-item">
        <a class="nav-link" href="index.html">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Dashboard</span></a>
    </li>

    <!-- Divider -->
    <li class="nav-item active">
        <a class="nav-link" href="<%=request.getContextPath()%>/user">
            <i class="fas fa-fw fa-table"></i>
            <span>User</span></a>
    </li>
    <hr class="sidebar-divider">

    <!-- Divider -->
    <li class="nav-item active">
        <a class="nav-link" href="<%=request.getContextPath()%>/brand">
            <i class="fas fa-fw fa-table"></i>
            <span>Brand</span></a>
    </li>
    <hr class="sidebar-divider">
    <li class="nav-item active">
        <a class="nav-link" href="<%=request.getContextPath()%>/category">
            <i class="fas fa-fw fa-table"></i>
            <span>Category</span></a>
    </li>
    <hr class="sidebar-divider">
    <li class="nav-item active">
        <a class="nav-link" href="<%=request.getContextPath()%>/table">
            <i class="fas fa-fw fa-table"></i>
            <span>Products</span></a>
    </li>

    <hr class="sidebar-divider d-none d-md-block">

    <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>

</ul>